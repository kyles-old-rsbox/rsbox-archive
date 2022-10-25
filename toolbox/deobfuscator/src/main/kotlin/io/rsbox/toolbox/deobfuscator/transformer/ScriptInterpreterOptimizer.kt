/*
 * Copyright (C) 2022 RSBox <Kyle Escobar>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

@file:Suppress("ObjectPropertyName", "unused")

package io.rsbox.toolbox.deobfuscator.transformer

import io.rsbox.toolbox.asm.*
import io.rsbox.toolbox.deobfuscator.Transformer
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.*
import org.tinylog.kotlin.Logger
import java.lang.reflect.Modifier

class ScriptInterpreterOptimizer : Transformer {

    private var count = 0

    private val opcodes = CS2Opcodes::class.java.declaredFields.filter { it.type == Integer.TYPE }.also {
        it.forEach { it.isAccessible = true }
    }.associate { it.name to it.getInt(null) }
    private val opcodeNames = opcodes.entries.associate { it.value to it.key }

    override fun run(pool: ClassPool) {
        /*
         * Load the 'CS2Opcodes' class from this transformer and
         * add it as a new class into the pool
         */
        val cs2OpcodesCls = ScriptInterpreterOptimizer::class.java.getResourceAsStream("/io/rsbox/toolbox/deobfuscator/transformer/ScriptInterpreterOptimizer\$CS2Opcodes.class")!!
            .readAllBytes().let { readClass(it) }
        cs2OpcodesCls.name = "CS2Opcodes"
        cs2OpcodesCls.init(pool)
        cs2OpcodesCls.reset()
        cs2OpcodesCls.build()
        pool.addClass(cs2OpcodesCls, ignore = true)

        /*
         * Find both the script and scriptEvent classes
         */
        var scriptCls: ClassNode? = null
        var scriptEventCls: ClassNode? = null

        pool.classes.forEach { cls ->
            cls.methods.forEach methodLoop@ { method ->
                val insns = method.instructions
                for(insn in insns) {
                    if(scriptCls == null && insn.matchesScriptInitializer()) {
                        scriptCls = cls
                    }
                    if(scriptEventCls == null && insn.matchesScriptEventConstructor()) {
                        scriptEventCls = cls
                    }
                }
            }
        }

        if(scriptCls == null || scriptEventCls == null) {
            Logger.warn("Failed to find 'Script' or 'ScriptEvent' classes.")
            return
        }

        pool.classes.forEach { cls ->
            cls.methods.forEach methodLoop@ { method ->
                if(!Modifier.isStatic(method.access)) return@methodLoop
                if(!method.type.argumentTypes.contains(scriptCls!!.type)
                    && !method.type.argumentTypes.contains(scriptEventCls!!.type)) return@methodLoop

                val varIdxKnown0 = method.type.argumentTypes.contains(scriptCls!!.type)

                val insns = method.instructions.iterator()
                var insn: AbstractInsnNode
                while(insns.hasNext()) {
                    insn = insns.next()
                    if(insn.opcode != ILOAD || (varIdxKnown0 && (insn as VarInsnNode).`var` != 0)) {
                        continue
                    }

                    insn = insns.next()
                    if(!insn.isNumberConstant()) {
                        continue
                    }

                    val opcode = insn.numberValue.toInt()
                    val opcodeName = opcodeNames[opcode]

                    insn = insns.next()
                    if(opcodeName == null || !(insn.opcode == IF_ICMPEQ || insn.opcode == IF_ICMPNE)) {
                        continue
                    }

                    insns.previous()
                    insns.previous()

                    val getStatic = FieldInsnNode(GETSTATIC, cs2OpcodesCls.name, opcodeName, "I")
                    insns.set(getStatic)
                    count++
                }
            }
        }

        Logger.info("Replaced $count CS2 opcode constants with fields.")
    }

    private fun AbstractInsnNode.matchesScriptEventConstructor(): Boolean {
        val i0 = this
        if(i0 !is VarInsnNode) return false
        if(i0.`var` != 0) return false
        val i1 = i0.next
        if(i1.opcode != BIPUSH) return false
        i1 as IntInsnNode
        if(i1.operand != 76) return false
        val i2 = i1.next
        if(i2.opcode != PUTFIELD) return false
        i2 as FieldInsnNode
        if(Type.getType(i2.desc) != Type.INT_TYPE) return false
        val i3 = i2.next
        if(i3.opcode != RETURN) return false
        return true
    }

    private fun AbstractInsnNode.matchesScriptInitializer(): Boolean {
        val i0 = this
        if(i0.opcode != NEW) return false
        val i1 = i0.next
        if(i1.opcode != DUP) return false
        val i2 = i1.next
        if(i2.opcode != SIPUSH) return false
        i2 as IntInsnNode
        if(i2.operand != 128) return false
        val i3 = i2.next
        if(i3.opcode != INVOKESPECIAL) return false
        val i4 = i3.next
        if(i4.opcode != PUTSTATIC) return false
        return true
    }

    private fun AbstractInsnNode.isNumberConstant() = when(opcode) {
        LDC -> (this as LdcInsnNode).cst is Number
        SIPUSH, BIPUSH, ICONST_M1, ICONST_0, ICONST_1, ICONST_2, ICONST_3, ICONST_4, ICONST_5 -> true
        else -> false
    }

    private val AbstractInsnNode.numberValue: Number get() {
        if(opcode in 2..8) return opcode - 3
        if(opcode == BIPUSH || opcode == SIPUSH) return (this as IntInsnNode).operand
        if(this is LdcInsnNode && cst is Number) return cst as Number
        throw IllegalArgumentException()
    }

    object CS2Opcodes {
        const val SS_AND = -2
        const val SS_OR = -1
        const val PUSH_CONSTANT_INT = 0
        const val PUSH_VAR = 1
        const val POP_VAR = 2
        const val PUSH_CONSTANT_STRING = 3
        const val BRANCH = 6
        const val BRANCH_NOT = 7
        const val BRANCH_EQUALS = 8
        const val BRANCH_LESS_THAN = 9
        const val BRANCH_GREATER_THAN = 10
        const val RETURN = 21
        const val PUSH_VARBIT = 25
        const val POP_VARBIT = 27
        const val BRANCH_LESS_THAN_OR_EQUALS = 31
        const val BRANCH_GREATER_THAN_OR_EQUALS = 32
        const val PUSH_INT_LOCAL = 33
        const val POP_INT_LOCAL = 34
        const val PUSH_STRING_LOCAL = 35
        const val POP_STRING_LOCAL = 36
        const val JOIN_STRING = 37
        const val POP_INT_DISCARD = 38
        const val POP_STRING_DISCARD = 39
        const val GOSUB_WITH_PARAMS = 40
        const val PUSH_VARC_INT = 42
        const val POP_VARC_INT = 43
        const val DEFINE_ARRAY = 44
        const val PUSH_ARRAY_INT = 45
        const val POP_ARRAY_INT = 46
        const val PUSH_VARC_STRING_OLD = 47
        const val POP_VARC_STRING_OLD = 48
        const val PUSH_VARC_STRING = 49
        const val POP_VARC_STRING = 50
        const val SWITCH = 60
        const val PUSH_VARCLANSETTING = 74
        const val PUSH_VARCLAN = 76
        const val CC_CREATE = 100
        const val CC_DELETE = 101
        const val CC_DELETEALL = 102
        const val _103 = 103
        const val _104 = 104
        const val CC_FIND = 200
        const val IF_FIND = 201
        const val _202 = 202
        const val _203 = 203
        const val CC_SETPOSITION = 1000
        const val CC_SETSIZE = 1001
        const val CC_SETHIDE = 1003
        const val CC_SETNOCLICKTHROUGH = 1005
        const val CC_SETNOSCROLLTHROUGH = 1006
        const val CC_SETSCROLLPOS = 1100
        const val CC_SETCOLOUR = 1101
        const val CC_SETFILL = 1102
        const val CC_SETTRANS = 1103
        const val CC_SETLINEWID = 1104
        const val CC_SETGRAPHIC = 1105
        const val CC_SET2DANGLE = 1106
        const val CC_SETTILING = 1107
        const val CC_SETMODEL = 1108
        const val CC_SETMODELANGLE = 1109
        const val CC_SETMODELANIM = 1110
        const val CC_SETMODELORTHOG = 1111
        const val CC_SETTEXT = 1112
        const val CC_SETTEXTFONT = 1113
        const val CC_SETTEXTALIGN = 1114
        const val CC_SETTEXTSHADOW = 1115
        const val CC_SETOUTLINE = 1116
        const val CC_SETGRAPHICSHADOW = 1117
        const val CC_SETVFLIP = 1118
        const val CC_SETHFLIP = 1119
        const val CC_SETSCROLLSIZE = 1120
        const val CC_RESUME_PAUSEBUTTON = 1121
        const val CC_SETCLICKMASK = 1122
        const val CC_SETFILLCOLOUR = 1123
        const val CC_SETFILLGRADIENT = 1124
        const val CC_SETFILLMODE = 1125
        const val CC_SETLINEDIRECTION = 1126
        const val CC_SETMODELTRANSPARENT = 1127
        const val CC_SETARC = 1128
        const val CC_SETHTTPSPRITE = 1129
        const val CC_SETCRM_URL = 1130
        const val CC_SETCRM_TEXTFONT = 1131
        const val CC_SETCRM_SERVERTARGETS = 1132
        const val CC_SETOBJECT = 1200
        const val CC_SETNPCHEAD = 1201
        const val CC_SETPLAYERHEAD_SELF = 1202
        const val CC_SETOBJECT_NONUM = 1205
        const val CC_SETOBJECT_ALWAYS_NUM = 1212
        const val CC_SETOP = 1300
        const val CC_SETDRAGGABLE = 1301
        const val CC_SETDRAGGABLEBEHAVIOR = 1302
        const val CC_SETDRAGDEADZONE = 1303
        const val CC_SETDRAGDEADTIME = 1304
        const val CC_SETOPBASE = 1305
        const val CC_SETTARGETVERB = 1306
        const val CC_CLEAROPS = 1307
        const val CC_SETSHIFTCLICKOP = 1308
        const val _1309 = 1309
        const val CC_SETOPKEY = 1350
        const val CC_SETOPTKEY = 1351
        const val CC_SETOPKEYRATE = 1352
        const val CC_SETOPTKEYRATE = 1353
        const val CC_SETOPKEYIGNOREHELD = 1354
        const val CC_SETOPTKEYIGNOREHELD = 1355
        const val CC_SETONCLICK = 1400
        const val CC_SETONHOLD = 1401
        const val CC_SETONRELEASE = 1402
        const val CC_SETONMOUSEOVER = 1403
        const val CC_SETONMOUSELEAVE = 1404
        const val CC_SETONDRAG = 1405
        const val CC_SETONTARGETLEAVE = 1406
        const val CC_SETONVARTRANSMIT = 1407
        const val CC_SETONTIMER = 1408
        const val CC_SETONOP = 1409
        const val CC_SETONDRAGCOMPLETE = 1410
        const val CC_SETONCLICKREPEAT = 1411
        const val CC_SETONMOUSEREPEAT = 1412
        const val CC_SETONINVTRANSMIT = 1414
        const val CC_SETONSTATTRANSMIT = 1415
        const val CC_SETONTARGETENTER = 1416
        const val CC_SETONSCROLLWHEEL = 1417
        const val CC_SETONCHATTRANSMIT = 1418
        const val CC_SETONKEY = 1419
        const val CC_SETONFRIENDTRANSMIT = 1420
        const val CC_SETONCLANTRANSMIT = 1421
        const val CC_SETONMISCTRANSMIT = 1422
        const val CC_SETONDIALOGABORT = 1423
        const val CC_SETONSUBCHANGE = 1424
        const val CC_SETONSTOCKTRANSMIT = 1425
        const val CC_SETONTRADINGPOSTTRANSMIT = 1426
        const val CC_SETONRESIZE = 1427
        const val CC_SETONCLANSETTINGSTRANSMIT = 1428
        const val CC_SETONCLANCHANNELTRANSMIT = 1429
        const val CC_SETONKEYDOWN = 1430
        const val CC_SETONKEYUP = 1431
        const val _1433 = 1433
        const val CC_SETONCRMVIEWLOAD = 1434
        const val CC_SETONOPT = 1435
        const val CC_SETONINPUT_1 = 1436
        const val CC_SETONINPUT_2 = 1437
        const val CC_SETONINPUT_3 = 1438
        const val CC_SETONINPUT_4 = 1439
        const val CC_GETX = 1500
        const val CC_GETY = 1501
        const val CC_GETWIDTH = 1502
        const val CC_GETHEIGHT = 1503
        const val CC_GETHIDE = 1504
        const val CC_GETLAYER = 1505
        const val CC_GETSCROLLX = 1600
        const val CC_GETSCROLLY = 1601
        const val CC_GETTEXT = 1602
        const val CC_GETSCROLLWIDTH = 1603
        const val CC_GETSCROLLHEIGHT = 1604
        const val CC_GETMODELZOOM = 1605
        const val CC_GETMODELANGLE_X = 1606
        const val CC_GETMODELANGLE_Z = 1607
        const val CC_GETMODELANGLE_Y = 1608
        const val CC_GETTRANS = 1609
        const val _1610 = 1610
        const val CC_GETCOLOUR = 1611
        const val CC_GETFILLCOLOUR = 1612
        const val _1613 = 1613
        const val CC_GETMODELTRANSPARENT = 1614
        const val _1615 = 1615
        const val _1616 = 1616
        const val CC_INPUTUNK1 = 1617
        const val CC_INPUTUNK2 = 1618
        const val CC_INPUTFIELDUNK1 = 1619
        const val CC_INPUTFIELDUNK2 = 1620
        const val CC_INPUTFIELDUNK3 = 1621
        const val CC_INPUTFIELDUNK4 = 1622
        const val CC_INPUTFIELDUNK5 = 1623
        const val CC_INPUTFIELDUNK6 = 1624
        const val CC_INPUTFIELDUNK7 = 1625
        const val CC_INPUTFIELDUNK8 = 1626
        const val CC_INPUTFIELDUNK9 = 1627
        const val CC_INPUTFIELDUNK10 = 1628
        const val CC_INPUTFIELDUNK11 = 1629
        const val CC_INPUTFIELDUNK12 = 1630
        const val CC_INPUTFIELDUNK13 = 1631
        const val CC_INPUTFIELDUNK14 = 1632
        const val CC_INPUTFIELDUNK15 = 1633
        const val CC_INPUTFIELDUNK16 = 1634
        const val CC_GETINVOBJECT = 1700
        const val CC_GETINVCOUNT = 1701
        const val CC_GETID = 1702
        const val CC_GETCRM_HASRESPONSE = 1707
        const val CC_GETCRM_INT = 1708
        const val CC_GETCRM_STRING = 1709
        const val CC_GETTARGETMASK = 1800
        const val CC_GETOP = 1801
        const val CC_GETOPBASE = 1802
        const val CC_CALLONRESIZE = 1927
        const val CC_TRIGGEROP = 1928
        const val IF_SETPOSITION = 2000
        const val IF_SETSIZE = 2001
        const val IF_SETHIDE = 2003
        const val IF_SETNOCLICKTHROUGH = 2005
        const val IF_SETNOSCROLLTHROUGH = 2006
        const val IF_SETSCROLLPOS = 2100
        const val IF_SETCOLOUR = 2101
        const val IF_SETFILL = 2102
        const val IF_SETTRANS = 2103
        const val IF_SETLINEWID = 2104
        const val IF_SETGRAPHIC = 2105
        const val IF_SET2DANGLE = 2106
        const val IF_SETTILING = 2107
        const val IF_SETMODEL = 2108
        const val IF_SETMODELANGLE = 2109
        const val IF_SETMODELANIM = 2110
        const val IF_SETMODELORTHOG = 2111
        const val IF_SETTEXT = 2112
        const val IF_SETTEXTFONT = 2113
        const val IF_SETTEXTALIGN = 2114
        const val IF_SETTEXTSHADOW = 2115
        const val IF_SETOUTLINE = 2116
        const val IF_SETGRAPHICSHADOW = 2117
        const val IF_SETVFLIP = 2118
        const val IF_SETHFLIP = 2119
        const val IF_SETSCROLLSIZE = 2120
        const val IF_RESUME_PAUSEBUTTON = 2121
        const val IF_SETCLICKMASK = 2122
        const val IF_SETFILLCOLOUR = 2123
        const val IF_SETFILLGRADIENT = 2124
        const val IF_SETFILLMODE = 2125
        const val IF_SETLINEDIRECTION = 2126
        const val IF_SETMODELTRANSPARENT = 2127
        const val IF_SETARC = 2128
        const val IF_SETHTTPSPRITE = 2129
        const val IF_SETCRM_URL = 2130
        const val IF_SETCRM_TEXTFONT = 2131
        const val IF_SETCRM_SERVERTARGETS = 2132
        const val IF_SETOBJECT = 2200
        const val IF_SETNPCHEAD = 2201
        const val IF_SETPLAYERHEAD_SELF = 2202
        const val IF_SETOBJECT_NONUM = 2205
        const val IF_SETOBJECT_ALWAYS_NUM = 2212
        const val IF_SETOP = 2300
        const val IF_SETDRAGGABLE = 2301
        const val IF_SETDRAGGABLEBEHAVIOR = 2302
        const val IF_SETDRAGDEADZONE = 2303
        const val IF_SETDRAGDEADTIME = 2304
        const val IF_SETOPBASE = 2305
        const val IF_SETTARGETVERB = 2306
        const val IF_CLEAROPS = 2307
        const val IF_SETSHIFTCLICKOP = 2308
        const val _2309 = 2309
        const val IF_SETOPKEY = 2350
        const val IF_SETOPTKEY = 2351
        const val IF_SETOPKEYRATE = 2352
        const val IF_SETOPTKEYRATE = 2353
        const val IF_SETOPKEYIGNOREHELD = 2354
        const val IF_SETOPTKEYIGNOREHELD = 2355
        const val IF_SETONCLICK = 2400
        const val IF_SETONHOLD = 2401
        const val IF_SETONRELEASE = 2402
        const val IF_SETONMOUSEOVER = 2403
        const val IF_SETONMOUSELEAVE = 2404
        const val IF_SETONDRAG = 2405
        const val IF_SETONTARGETLEAVE = 2406
        const val IF_SETONVARTRANSMIT = 2407
        const val IF_SETONTIMER = 2408
        const val IF_SETONOP = 2409
        const val IF_SETONDRAGCOMPLETE = 2410
        const val IF_SETONCLICKREPEAT = 2411
        const val IF_SETONMOUSEREPEAT = 2412
        const val IF_SETONINVTRANSMIT = 2414
        const val IF_SETONSTATTRANSMIT = 2415
        const val IF_SETONTARGETENTER = 2416
        const val IF_SETONSCROLLWHEEL = 2417
        const val IF_SETONCHATTRANSMIT = 2418
        const val IF_SETONKEY = 2419
        const val IF_SETONFRIENDTRANSMIT = 2420
        const val IF_SETONCLANTRANSMIT = 2421
        const val IF_SETONMISCTRANSMIT = 2422
        const val IF_SETONDIALOGABORT = 2423
        const val IF_SETONSUBCHANGE = 2424
        const val IF_SETONSTOCKTRANSMIT = 2425
        const val IF_SETONTRADINGPOSTTRANSMIT = 2426
        const val IF_SETONRESIZE = 2427
        const val IF_SETONCLANSETTINGSTRANSMIT = 2428
        const val IF_SETONCLANCHANNELTRANSMIT = 2429
        const val IF_SETONKEYDOWN = 2430
        const val IF_SETONKEYUP = 2431
        const val _2433 = 2433
        const val IF_SETONCRMVIEWLOAD = 2434
        const val IF_SETONOPT = 2435
        const val IF_SETONINPUT_1 = 2436
        const val IF_SETONINPUT_2 = 2437
        const val IF_SETONINPUT_3 = 2438
        const val IF_SETONINPUT_4 = 2439
        const val IF_GETX = 2500
        const val IF_GETY = 2501
        const val IF_GETWIDTH = 2502
        const val IF_GETHEIGHT = 2503
        const val IF_GETHIDE = 2504
        const val IF_GETLAYER = 2505
        const val IF_GETSCROLLX = 2600
        const val IF_GETSCROLLY = 2601
        const val IF_GETTEXT = 2602
        const val IF_GETSCROLLWIDTH = 2603
        const val IF_GETSCROLLHEIGHT = 2604
        const val IF_GETMODELZOOM = 2605
        const val IF_GETMODELANGLE_X = 2606
        const val IF_GETMODELANGLE_Z = 2607
        const val IF_GETMODELANGLE_Y = 2608
        const val IF_GETTRANS = 2609
        const val _2610 = 2610
        const val IF_GETCOLOUR = 2611
        const val IF_GETFILLCOLOUR = 2612
        const val _2613 = 2613
        const val IF_GETMODELTRANSPARENT = 2614
        const val _2615 = 2615
        const val _2616 = 2616
        const val IF_INPUTUNK1 = 2617
        const val IF_INPUTUNK2 = 2618
        const val IF_INPUTFIELDUNK1 = 2619
        const val IF_INPUTFIELDUNK2 = 2620
        const val IF_INPUTFIELDUNK3 = 2621
        const val IF_INPUTFIELDUNK4 = 2622
        const val IF_INPUTFIELDUNK5 = 2623
        const val IF_INPUTFIELDUNK6 = 2624
        const val IF_INPUTFIELDUNK7 = 2625
        const val IF_INPUTFIELDUNK8 = 2626
        const val IF_INPUTFIELDUNK9 = 2627
        const val IF_INPUTFIELDUNK10 = 2628
        const val IF_INPUTFIELDUNK11 = 2629
        const val IF_INPUTFIELDUNK12 = 2630
        const val IF_INPUTFIELDUNK13 = 2631
        const val IF_INPUTFIELDUNK14 = 2632
        const val IF_INPUTFIELDUNK15 = 2633
        const val IF_INPUTFIELDUNK16 = 2634
        const val IF_GETINVOBJECT = 2700
        const val IF_GETINVCOUNT = 2701
        const val IF_HASSUB = 2702
        const val IF_GETTOP = 2706
        const val IF_GETCRM_HASRESPONSE = 2707
        const val IF_GETCRM_INT = 2708
        const val IF_GETCRM_STRING = 2709
        const val IF_GETTARGETMASK = 2800
        const val IF_GETOP = 2801
        const val IF_GETOPBASE = 2802
        const val IF_CALLONRESIZE = 2927
        const val IF_TRIGGEROP = 2928
        const val MES = 3100
        const val ANIM = 3101
        const val IF_CLOSE = 3103
        const val RESUME_COUNTDIALOG = 3104
        const val RESUME_NAMEDIALOG = 3105
        const val RESUME_STRINGDIALOG = 3106
        const val OPPLAYER = 3107
        const val IF_DRAGPICKUP = 3108
        const val CC_DRAGPICKUP = 3109
        const val SETMOUSECAM = 3110
        const val GETREMOVEROOFS = 3111
        const val SETREMOVEROOFS = 3112
        const val OPENURL = 3113
        const val RESUME_OBJDIALOG = 3115
        const val BUG_REPORT = 3116
        const val SETSHIFTCLICKDROP = 3117
        const val SETSHOWMOUSEOVERTEXT = 3118
        const val RENDERSELF = 3119
        const val _3120 = 3120
        const val _3121 = 3121
        const val _3122 = 3122
        const val _3123 = 3123
        const val _3124 = 3124
        const val SETSHOWMOUSECROSS = 3125
        const val SETSHOWLOADINGMESSAGES = 3126
        const val SETTAPTODROP = 3127
        const val GETTAPTODROP = 3128
        const val _3129 = 3129
        const val _3130 = 3130
        const val _3131 = 3131
        const val GETCANVASSIZE = 3132
        const val MOBILE_SETFPS = 3133
        const val MOBILE_OPENSTORE = 3134
        const val MOBILE_OPENSTORECATEGORY = 3135
        const val _3136 = 3136
        const val _3137 = 3137
        const val _3138 = 3138
        const val _3139 = 3139
        const val _3140 = 3140
        const val SETHIDEUSERNAME = 3141
        const val GETHIDEUSERNAME = 3142
        const val SETREMEMBERUSERNAME = 3143
        const val GETREMEMBERUSERNAME = 3144
        const val SHOW_IOS_REVIEW = 3145
        const val SETTITLEMUSICDISABLED = 3146
        const val GETTITLEMUSICDISABLED = 3147
        const val _3148 = 3148
        const val _3149 = 3149
        const val _3150 = 3150
        const val _3151 = 3151
        const val _3152 = 3152
        const val _3153 = 3153
        const val _3154 = 3154
        const val _3155 = 3155
        const val _3156 = 3156
        const val _3157 = 3157
        const val _3158 = 3158
        const val _3159 = 3159
        const val _3160 = 3160
        const val _3161 = 3161
        const val _3162 = 3162
        const val _3163 = 3163
        const val _3164 = 3164
        const val _3165 = 3165
        const val _3166 = 3166
        const val _3167 = 3167
        const val _3168 = 3168
        const val _3169 = 3169
        const val LOCAL_NOTIFICATION = 3170
        const val _3171 = 3171
        const val _3172 = 3172
        const val _3173 = 3173
        const val _3174 = 3174
        const val _3175 = 3175
        const val _3176 = 3176
        const val _3177 = 3177
        const val _3178 = 3178
        const val _3179 = 3179
        const val _3180 = 3180
        const val SETBRIGHTNESS = 3181
        const val GETBRIGHTNESS = 3182
        const val SETANTIDRAG = 3183
        const val _3184 = 3184
        const val _3189 = 3189
        const val SOUND_SYNTH = 3200
        const val SOUND_SONG = 3201
        const val SOUND_JINGLE = 3202
        const val SETVOLUMEMUSIC = 3203
        const val GETVOLUMEMUSIC = 3204
        const val SETVOLUMESOUNDS = 3205
        const val GETVOLUMESOUNDS = 3206
        const val SETVOLUMEAREASOUNDS = 3207
        const val GETVOLUMEAREASOUNDS = 3208
        const val SETCLIENTOPTION = 3209
        const val GETCLIENTOPTION = 3210
        const val _3211 = 3211
        const val SETDEVICEOPTION = 3212
        const val SETGAMEOPTION = 3213
        const val GETDEVICEOPTION = 3214
        const val GETGAMEOPTION = 3215
        const val CLIENTCLOCK = 3300
        const val INV_GETOBJ = 3301
        const val INV_GETNUM = 3302
        const val INV_TOTAL = 3303
        const val INV_SIZE = 3304
        const val STAT = 3305
        const val STAT_BASE = 3306
        const val STAT_XP = 3307
        const val COORD = 3308
        const val COORDX = 3309
        const val COORDY = 3310
        const val COORDZ = 3311
        const val MAP_MEMBERS = 3312
        const val INVOTHER_GETOBJ = 3313
        const val INVOTHER_GETNUM = 3314
        const val INVOTHER_TOTAL = 3315
        const val STAFFMODLEVEL = 3316
        const val REBOOTTIMER = 3317
        const val MAP_WORLD = 3318
        const val RUNENERGY_VISIBLE = 3321
        const val RUNWEIGHT_VISIBLE = 3322
        const val PLAYERMOD = 3323
        const val WORLDFLAGS = 3324
        const val MOVECOORD = 3325
        const val MOUSE_GETX = 3326
        const val MOUSE_GETY = 3327
        const val _3328 = 3328
        const val _3329 = 3329
        const val _3330 = 3330
        const val ENUM_STRING = 3400
        const val ENUM = 3408
        const val ENUM_GETOUTPUTCOUNT = 3411
        const val KEYHELD = 3500
        const val KEYPRESSED = 3501
        const val KEYRELEASED = 3502
        const val FRIEND_COUNT = 3600
        const val FRIEND_GETNAME = 3601
        const val FRIEND_GETWORLD = 3602
        const val FRIEND_GETRANK = 3603
        const val FRIEND_SETRANK = 3604
        const val FRIEND_ADD = 3605
        const val FRIEND_DEL = 3606
        const val IGNORE_ADD = 3607
        const val IGNORE_DEL = 3608
        const val FRIEND_TEST = 3609
        const val CLAN_GETCHATDISPLAYNAME = 3611
        const val CLAN_GETCHATCOUNT = 3612
        const val CLAN_GETCHATUSERNAME = 3613
        const val CLAN_GETCHATUSERWORLD = 3614
        const val CLAN_GETCHATUSERRANK = 3615
        const val CLAN_GETCHATMINKICK = 3616
        const val CLAN_KICKUSER = 3617
        const val CLAN_GETCHATRANK = 3618
        const val CLAN_JOINCHAT = 3619
        const val CLAN_LEAVECHAT = 3620
        const val IGNORE_COUNT = 3621
        const val IGNORE_GETNAME = 3622
        const val IGNORE_TEST = 3623
        const val CLAN_ISSELF = 3624
        const val CLAN_GETCHATOWNERNAME = 3625
        const val CLAN_ISFRIEND = 3626
        const val CLAN_ISIGNORE = 3627
        const val _3628 = 3628
        const val _3629 = 3629
        const val _3630 = 3630
        const val _3631 = 3631
        const val _3632 = 3632
        const val _3633 = 3633
        const val _3634 = 3634
        const val _3635 = 3635
        const val _3636 = 3636
        const val _3637 = 3637
        const val _3638 = 3638
        const val _3639 = 3639
        const val _3640 = 3640
        const val _3641 = 3641
        const val _3642 = 3642
        const val _3643 = 3643
        const val _3644 = 3644
        const val _3645 = 3645
        const val _3646 = 3646
        const val _3647 = 3647
        const val _3648 = 3648
        const val _3649 = 3649
        const val _3650 = 3650
        const val _3651 = 3651
        const val _3652 = 3652
        const val _3653 = 3653
        const val _3654 = 3654
        const val _3655 = 3655
        const val _3656 = 3656
        const val _3657 = 3657
        const val _3700 = 3700
        const val _3701 = 3701
        const val _3702 = 3702
        const val ACTIVECLANSETTINGS_FIND_LISTENED = 3800
        const val ACTIVECLANSETTINGS_FIND_AFFINED = 3801
        const val ACTIVECLANSETTINGS_GETCLANNAME = 3802
        const val ACTIVECLANSETTINGS_GETALLOWUNAFFINED = 3803
        const val ACTIVECLANSETTINGS_GETRANKTALK = 3804
        const val ACTIVECLANSETTINGS_GETRANKKICK = 3805
        const val ACTIVECLANSETTINGS_GETRANKLOOTSHARE = 3806
        const val ACTIVECLANSETTINGS_GETCOINSHARE = 3807
        const val ACTIVECLANSETTINGS_GETAFFINEDCOUNT = 3809
        const val ACTIVECLANSETTINGS_GETAFFINEDDISPLAYNAME = 3810
        const val ACTIVECLANSETTINGS_GETAFFINEDRANK = 3811
        const val ACTIVECLANSETTINGS_GETBANNEDCOUNT = 3812
        const val ACTIVECLANSETTINGS_GETBANNEDDISPLAYNAME = 3813
        const val ACTIVECLANSETTINGS_GETAFFINEDEXTRAINFO = 3814
        const val ACTIVECLANSETTINGS_GETCURRENTOWNER_SLOT = 3815
        const val ACTIVECLANSETTINGS_GETREPLACEMENTOWNER_SLOT = 3816
        const val ACTIVECLANSETTINGS_GETAFFINEDSLOT = 3817
        const val ACTIVECLANSETTINGS_GETSORTEDAFFINEDSLOT = 3818
        const val AFFINEDCLANSETTINGS_ADDBANNED_FROMCHANNEL = 3819
        const val ACTIVECLANSETTINGS_GETAFFINEDJOINRUNEDAY = 3820
        const val AFFINEDCLANSETTINGS_SETMUTED_FROMCHANNEL = 3821
        const val ACTIVECLANSETTINGS_GETAFFINEDMUTED = 3822
        const val ACTIVECLANCHANNEL_FIND_LISTENED = 3850
        const val ACTIVECLANCHANNEL_FIND_AFFINED = 3851
        const val ACTIVECLANCHANNEL_GETCLANNAME = 3852
        const val ACTIVECLANCHANNEL_GETRANKKICK = 3853
        const val ACTIVECLANCHANNEL_GETRANKTALK = 3854
        const val ACTIVECLANCHANNEL_GETUSERCOUNT = 3855
        const val ACTIVECLANCHANNEL_GETUSERDISPLAYNAME = 3856
        const val ACTIVECLANCHANNEL_GETUSERRANK = 3857
        const val ACTIVECLANCHANNEL_GETUSERWORLD = 3858
        const val ACTIVECLANCHANNEL_KICKUSER = 3859
        const val ACTIVECLANCHANNEL_GETUSERSLOT = 3860
        const val ACTIVECLANCHANNEL_GETSORTEDUSERSLOT = 3861
        const val CLANPROFILE_FIND = 3890
        const val STOCKMARKET_GETOFFERTYPE = 3903
        const val STOCKMARKET_GETOFFERITEM = 3904
        const val STOCKMARKET_GETOFFERPRICE = 3905
        const val STOCKMARKET_GETOFFERCOUNT = 3906
        const val STOCKMARKET_GETOFFERCOMPLETEDCOUNT = 3907
        const val STOCKMARKET_GETOFFERCOMPLETEDGOLD = 3908
        const val STOCKMARKET_ISOFFEREMPTY = 3910
        const val STOCKMARKET_ISOFFERSTABLE = 3911
        const val STOCKMARKET_ISOFFERFINISHED = 3912
        const val STOCKMARKET_ISOFFERADDING = 3913
        const val TRADINGPOST_SORTBY_NAME = 3914
        const val TRADINGPOST_SORTBY_PRICE = 3915
        const val TRADINGPOST_SORTFILTERBY_WORLD = 3916
        const val TRADINGPOST_SORTBY_AGE = 3917
        const val TRADINGPOST_SORTBY_COUNT = 3918
        const val TRADINGPOST_GETTOTALOFFERS = 3919
        const val TRADINGPOST_GETOFFERWORLD = 3920
        const val TRADINGPOST_GETOFFERNAME = 3921
        const val TRADINGPOST_GETOFFERPREVIOUSNAME = 3922
        const val TRADINGPOST_GETOFFERAGE = 3923
        const val TRADINGPOST_GETOFFERCOUNT = 3924
        const val TRADINGPOST_GETOFFERPRICE = 3925
        const val TRADINGPOST_GETOFFERITEM = 3926
        const val ADD = 4000
        const val SUB = 4001
        const val MULTIPLY = 4002
        const val DIV = 4003
        const val RANDOM = 4004
        const val RANDOMINC = 4005
        const val INTERPOLATE = 4006
        const val ADDPERCENT = 4007
        const val SETBIT = 4008
        const val CLEARBIT = 4009
        const val TESTBIT = 4010
        const val MOD = 4011
        const val POW = 4012
        const val INVPOW = 4013
        const val AND = 4014
        const val OR = 4015
        const val SCALE = 4018
        const val BITCOUNT = 4025
        const val TOGGLEBIT = 4026
        const val SETBIT_RANGE = 4027
        const val CLEARBIT_RANGE = 4028
        const val GETBIT_RANGE = 4029
        const val SETBIT_RANGE_TOINT = 4030
        const val SIN_DEG = 4032
        const val COS_DEG = 4033
        const val ATAN2_DEG = 4034
        const val ABS = 4035
        const val APPEND_NUM = 4100
        const val APPEND = 4101
        const val APPEND_SIGNNUM = 4102
        const val LOWERCASE = 4103
        const val FROMDATE = 4104
        const val TEXT_BODYTYPE = 4105
        const val TOSTRING = 4106
        const val COMPARE = 4107
        const val PARAHEIGHT = 4108
        const val PARAWIDTH = 4109
        const val TEXT_SWITCH = 4110
        const val ESCAPE = 4111
        const val APPEND_CHAR = 4112
        const val CHAR_ISPRINTABLE = 4113
        const val CHAR_ISALPHANUMERIC = 4114
        const val CHAR_ISALPHA = 4115
        const val CHAR_ISNUMERIC = 4116
        const val STRING_LENGTH = 4117
        const val SUBSTRING = 4118
        const val REMOVETAGS = 4119
        const val STRING_INDEXOF_CHAR = 4120
        const val STRING_INDEXOF_STRING = 4121
        const val UPPERCASE = 4122
        const val TEXT_GENDER = 4123
        const val OC_NAME = 4200
        const val OC_OP = 4201
        const val OC_IOP = 4202
        const val OC_COST = 4203
        const val OC_STACKABLE = 4204
        const val OC_CERT = 4205
        const val OC_UNCERT = 4206
        const val OC_MEMBERS = 4207
        const val OC_PLACEHOLDER = 4208
        const val OC_UNPLACEHOLDER = 4209
        const val OC_FIND = 4210
        const val OC_FINDNEXT = 4211
        const val OC_FINDRESET = 4212
        const val OC_SHIFTCLICKOP = 4213
        const val OC_WEARPOS = 4214
        const val OC_WEARPOS2 = 4215
        const val OC_WEARPOS3 = 4216
        const val OC_WEIGHT = 4217
        const val _4218 = 4218
        const val CHAT_GETFILTER_PUBLIC = 5000
        const val CHAT_SETFILTER = 5001
        const val CHAT_SENDABUSEREPORT = 5002
        const val CHAT_GETHISTORY_BYTYPEANDLINE_OLD = 5003
        const val CHAT_GETHISTORY_BYUID_OLD = 5004
        const val CHAT_GETFILTER_PRIVATE = 5005
        const val CHAT_SENDPUBLIC = 5008
        const val CHAT_SENDPRIVATE = 5009
        const val CHAT_SENDCLAN = 5010
        const val CHAT_PLAYERNAME = 5015
        const val CHAT_GETFILTER_TRADE = 5016
        const val CHAT_GETHISTORYLENGTH = 5017
        const val CHAT_GETNEXTUID = 5018
        const val CHAT_GETPREVUID = 5019
        const val DOCHEAT = 5020
        const val CHAT_SETMESSAGEFILTER = 5021
        const val CHAT_GETMESSAGEFILTER = 5022
        const val WRITECONSOLE = 5023
        const val CHAT_SETTIMESTAMPS = 5024
        const val CHAT_GETTIMESTAMPS = 5025
        const val CHAT_GETHISTORY_BYTYPEANDLINE = 5030
        const val CHAT_GETHISTORY_BYUID = 5031
        const val GETWINDOWMODE = 5306
        const val SETWINDOWMODE = 5307
        const val GETDEFAULTWINDOWMODE = 5308
        const val SETDEFAULTWINDOWMODE = 5309
        const val _5310 = 5310
        const val _5311 = 5311
        const val _5312 = 5312
        const val _5350 = 5350
        const val _5351 = 5351
        const val CAM_FORCEANGLE = 5504
        const val CAM_GETANGLE_XA = 5505
        const val CAM_GETANGLE_YA = 5506
        const val CAM_SETFOLLOWHEIGHT = 5530
        const val CAM_GETFOLLOWHEIGHT = 5531
        const val LOGOUT = 5630
        const val FEDERATED_LOGIN = 5631
        const val _5632 = 5632
        const val _5633 = 5633
        const val VIEWPORT_SETFOV = 6200
        const val VIEWPORT_SETZOOM = 6201
        const val VIEWPORT_CLAMPFOV = 6202
        const val VIEWPORT_GETEFFECTIVESIZE = 6203
        const val VIEWPORT_GETZOOM = 6204
        const val VIEWPORT_GETFOV = 6205
        const val _6210 = 6210
        const val _6212 = 6212
        const val VIEWPORT_GETX = 6220
        const val VIEWPORT_GETY = 6221
        const val VIEWPORT_GETWIDTH = 6222
        const val VIEWPORT_GETHEIGHT = 6223
        const val _6230 = 6230
        const val _6231 = 6231
        const val _6232 = 6232
        const val WORLDLIST_FETCH = 6500
        const val WORLDLIST_START = 6501
        const val WORLDLIST_NEXT = 6502
        const val WORLDLIST_SPECIFIC = 6506
        const val WORLDLIST_SORT = 6507
        const val _6511 = 6511
        const val SETFOLLOWEROPSLOWPRIORITY = 6512
        const val NC_PARAM = 6513
        const val LC_PARAM = 6514
        const val OC_PARAM = 6515
        const val STRUCT_PARAM = 6516
        const val ON_MOBILE = 6518
        const val CLIENTTYPE = 6519
        const val _6520 = 6520
        const val MOBILE_KEYBOARDHIDE = 6521
        const val _6522 = 6522
        const val _6523 = 6523
        const val MOBILE_BATTERYLEVEL = 6524
        const val MOBILE_BATTERYCHARGING = 6525
        const val MOBILE_WIFIAVAILABLE = 6526
        const val PLATFORMTYPE = 6527
        const val _6600 = 6600
        const val WORLDMAP_GETMAPNAME = 6601
        const val WORLDMAP_SETMAP = 6602
        const val WORLDMAP_GETZOOM = 6603
        const val WORLDMAP_SETZOOM = 6604
        const val WORLDMAP_ISLOADED = 6605
        const val WORLDMAP_JUMPTODISPLAYCOORD = 6606
        const val WORLDMAP_JUMPTODISPLAYCOORD_INSTANT = 6607
        const val WORLDMAP_JUMPTOSOURCECOORD = 6608
        const val WORLDMAP_JUMPTOSOURCECOORD_INSTANT = 6609
        const val WORLDMAP_GETDISPLAYPOSITION = 6610
        const val WORLDMAP_GETCONFIGORIGIN = 6611
        const val WORLDMAP_GETCONFIGSIZE = 6612
        const val WORLDMAP_GETCONFIGBOUNDS = 6613
        const val WORLDMAP_GETCONFIGZOOM = 6614
        const val _6615 = 6615
        const val WORLDMAP_GETCURRENTMAP = 6616
        const val WORLDMAP_GETDISPLAYCOORD = 6617
        const val _6618 = 6618
        const val _6619 = 6619
        const val _6620 = 6620
        const val WORLDMAP_COORDINMAP = 6621
        const val WORLDMAP_GETSIZE = 6622
        const val _6623 = 6623
        const val _6624 = 6624
        const val _6625 = 6625
        const val _6626 = 6626
        const val _6627 = 6627
        const val WORLDMAP_PERPETUALFLASH = 6628
        const val WORLDMAP_FLASHELEMENT = 6629
        const val WORLDMAP_FLASHELEMENTCATEGORY = 6630
        const val WORLDMAP_STOPCURRENTFLASHES = 6631
        const val WORLDMAP_DISABLEELEMENTS = 6632
        const val WORLDMAP_DISABLEELEMENT = 6633
        const val WORLDMAP_DISABLEELEMENTCATEGORY = 6634
        const val WORLDMAP_GETDISABLEELEMENTS = 6635
        const val WORLDMAP_GETDISABLEELEMENT = 6636
        const val WORLDMAP_GETDISABLEELEMENTCATEGORY = 6637
        const val _6638 = 6638
        const val WORLDMAP_LISTELEMENT_START = 6639
        const val WORLDMAP_LISTELEMENT_NEXT = 6640
        const val MEC_TEXT = 6693
        const val MEC_TEXTSIZE = 6694
        const val MEC_CATEGORY = 6695
        const val MEC_SPRITE = 6696
        const val WORLDMAP_ELEMENT = 6697
        const val _6698 = 6698
        const val WORLDMAP_ELEMENTCOORD = 6699
        const val _6700 = 6700
        const val _6701 = 6701
        const val _6702 = 6702
        const val _6703 = 6703
        const val _6704 = 6704
        const val _6705 = 6705
        const val _6706 = 6706
        const val _6707 = 6707
        const val _6708 = 6708
        const val _6709 = 6709
        const val NPC_NAME = 6750
        const val NPC_UID = 6751
        const val _6752 = 6752
        const val NPC_TYPE = 6753
        const val NC_NAME = 6754
        const val NPC_FIND = 6758
        const val _6761 = 6761
        const val _6762 = 6762
        const val LOC_NAME = 6800
        const val LOC_COORD = 6801
        const val LOC_TYPE = 6802
        const val LOC_FIND = 6803
        const val _6806 = 6806
        const val _6807 = 6807
        const val LC_NAME = 6809
        const val OBJ_NAME = 6850
        const val OBJ_COORD = 6851
        const val OBJ_TYPE = 6852
        const val _6853 = 6853
        const val _6854 = 6854
        const val _6857 = 6857
        const val _6858 = 6858
        const val PLAYER_NAME = 6900
        const val _6901 = 6901
        const val _6902 = 6902
        const val _6903 = 6903
        const val PLAYER_UID = 6904
        const val SELF_PLAYER_UID = 6905
        const val _6950 = 6950
        const val _6951 = 6951
        const val _7000 = 7000
        const val HIGHLIGHT_NPC_ON = 7001
        const val HIGHLIGHT_NPC_OFF = 7002
        const val _7003 = 7003
        const val _7004 = 7004
        const val _7005 = 7005
        const val HIGHLIGHT_NPCTYPE_ON = 7006
        const val HIGHLIGHT_NPCTYPE_OFF = 7007
        const val _7008 = 7008
        const val _7009 = 7009
        const val _7010 = 7010
        const val HIGHLIGHT_LOC_ON = 7011
        const val HIGHLIGHT_LOC_OFF = 7012
        const val _7013 = 7013
        const val _7014 = 7014
        const val _7015 = 7015
        const val HIGHLIGHT_LOCTYPE_ON = 7016
        const val HIGHLIGHT_LOCTYPE_OFF = 7017
        const val _7018 = 7018
        const val _7019 = 7019
        const val _7020 = 7020
        const val HIGHLIGHT_OBJ_ON = 7021
        const val HIGHLIGHT_OBJ_OFF = 7022
        const val _7023 = 7023
        const val _7024 = 7024
        const val _7025 = 7025
        const val HIGHLIGHT_OBJTYPE_ON = 7026
        const val HIGHLIGHT_OBJTYPE_OFF = 7027
        const val _7028 = 7028
        const val _7029 = 7029
        const val _7030 = 7030
        const val HIGHLIGHT_PLAYER_ON = 7031
        const val HIGHLIGHT_PLAYER_OFF = 7032
        const val _7033 = 7033
        const val _7034 = 7034
        const val _7035 = 7035
        const val HIGHLIGHT_TILE_ON = 7036
        const val HIGHLIGHT_TILE_OFF = 7037
        const val _7038 = 7038
        const val _7039 = 7039
        const val _7040 = 7040
        const val _7041 = 7041
        const val _7042 = 7042
        const val _7043 = 7043
        const val _7044 = 7044
        const val GET_ACTIVE_MINIMENU_ENTRY_TYPE = 7100
        const val GET_ACTIVE_MINIMENU_ENTRY = 7101
        const val NPC_FIND_ACTIVE_MINIMENU_ENTRY = 7102
        const val LOC_FIND_ACTIVE_MINIMENU_ENTRY = 7103
        const val OBJ_FIND_ACTIVE_MINIMENU_ENTRY = 7104
        const val PLAYER_FIND_ACTIVE_MINIMENU_ENTRY = 7105
        const val _7106 = 7106
        const val _7107 = 7107
        const val ISMENUOPEN = 7108
        const val TARGETMODE_ACTIVE = 7109
        const val GET_MINIMENU_LENGTH = 7110
        const val _7120 = 7120
        const val _7121 = 7121
        const val _7122 = 7122
        const val _7200 = 7200
        const val _7201 = 7201
        const val _7202 = 7202
        const val _7203 = 7203
        const val _7204 = 7204
        const val _7205 = 7205
        const val _7206 = 7206
        const val _7207 = 7207
        const val _7208 = 7208
        const val _7209 = 7209
        const val _7210 = 7210
        const val _7211 = 7211
        const val _7212 = 7212
        const val _7213 = 7213
        const val _7214 = 7214
        const val SETMINIMAPLOCK = 7250
        const val _7252 = 7252
        const val _7254 = 7254
        const val _7451 = 7451
        const val _7453 = 7453
        const val _7454 = 7454
        const val _7455 = 7455
        const val _7456 = 7456
        const val _7460 = 7460
        const val _7462 = 7462
        const val CLIENTVARP_MOUSEBUTTONMODE = 7463
        const val DB_FIND_WITH_COUNT = 7500
        const val DB_FINDNEXT = 7501
        const val DB_GETFIELD = 7502
        const val DB_GETFIELDCOUNT = 7503
        const val DB_FINDALL_WITH_COUNT = 7504
        const val DB_GETROWTABLE = 7505
        const val DB_GETROW = 7506
        const val DB_FIND_FILTER_WITH_COUNT = 7507
        const val DB_FIND = 7508
        const val DB_FINDALL = 7509
        const val DB_FIND_FILTER = 7510
    }
}