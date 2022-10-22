package io.rsbox.toolbox.deobfuscator.transformer

import LabelMap
import io.rsbox.toolbox.deobfuscator.Transformer
import io.rsbox.toolbox.deobfuscator.asm.ClassPool
import io.rsbox.toolbox.deobfuscator.asm.owner
import org.objectweb.asm.tree.AbstractInsnNode.*
import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.LineNumberNode
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.analysis.Analyzer
import org.objectweb.asm.tree.analysis.BasicInterpreter
import org.objectweb.asm.tree.analysis.BasicValue
import org.tinylog.kotlin.Logger
import java.util.Stack

class ControlFlowFixer : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        pool.classes.forEach { cls ->
            cls.methods.forEach methodLoop@{ method ->
                if(method.tryCatchBlocks.isEmpty()) {
                    val cfg = ControlFlowGraph()
                    cfg.build(cls.name, method)
                    val newInsns = InsnList()
                    if(cfg.blocks.isNotEmpty()) {
                        val labelMap = LabelMap()
                        val queue = Stack<Block>()
                        val visited = hashSetOf<Block>()
                        queue.add(cfg.blocks.first())
                        while(queue.isNotEmpty()) {
                            val block = queue.pop()
                            if(block in visited) continue
                            visited.add(block)
                            block.branches.forEach { queue.add(it.head) }
                            block.next?.let { queue.add(it) }
                            for(i in block.start until block.end) {
                                newInsns.add(method.instructions[i].clone(labelMap))
                            }
                        }
                    }
                    method.instructions = newInsns
                    count += cfg.blocks.size
                }
            }
        }

        Logger.info("Reordered $count control-flow blocks.")
    }

    private class Block : Comparable<Block> {
        var start = 0
        var end = 0

        var prev: Block? = null
        var next: Block? = null

        val branches = mutableListOf<Block>()
        val instructions = InsnList()

        val head: Block get() {
            var cur = this
            var last = cur.prev
            while(last != null) {
                cur = last
                last = cur.prev
            }
            return cur
        }

        val lineNumber: Int get() {
            instructions.forEach { insn ->
                if(insn is LineNumberNode) {
                    return insn.line
                }
            }
            return -1
        }

        override fun compareTo(other: Block): Int {
            val l1 = this.lineNumber
            val l2 = other.lineNumber
            if(l1 == l2 || l1 == -1 || l2 == -1) {
                return 0
            }
            return l1.compareTo(l2)
        }
    }

    private class ControlFlowGraph {

        val blocks = mutableListOf<Block>()

        private lateinit var head: Block

        private val analyzer = object : Analyzer<BasicValue>(BasicInterpreter()) {

            override fun init(owner: String, method: MethodNode) {
                val insns = method.instructions
                var cur = Block()
                head = cur
                blocks.add(cur)
                for(i in 0 until insns.size()) {
                    val insn = insns[i]
                    cur.end++
                    if(insn.next == null) break
                    if(insn.next.type == LABEL || insn.type == JUMP_INSN || insn.type == LOOKUPSWITCH_INSN || insn.type == TABLESWITCH_INSN) {
                        cur = Block()
                        cur.start = i + 1
                        cur.end = i + 1
                        blocks.add(cur)
                    }
                }
            }

            override fun newControlFlowEdge(insnIndex: Int, successorIndex: Int) {
                val cur = blocks.first { insnIndex in it.start until it.end }
                val next = blocks.first { successorIndex in it.start until it.end }
                if(cur != next) {
                    if(insnIndex + 1 == successorIndex) {
                        cur.next = next
                        next.prev = cur
                    } else {
                        cur.branches.add(next)
                    }
                }
            }
        }

        fun build(owner: String, method: MethodNode) {
            analyzer.analyze(owner, method)
        }

        private fun sorted() {
            val ret = mutableListOf<Block>()
            walk(head, ret, mutableListOf())
            val reverse = ret.asReversed()
            blocks.clear()
            blocks.addAll(reverse)
        }

        private fun walk(cur: Block, ordered: MutableList<Block>, visited: MutableList<Block>) {
            val next = cur.next
            if(next != null && visited.add(next)) {
                walk(next, ordered, visited)
            }
            val branches = cur.branches
            branches.sort()
            branches.forEach { branch ->
                if(visited.add(branch)) {
                    walk(branch, ordered, visited)
                }
            }
            ordered.add(cur)
        }
    }
}