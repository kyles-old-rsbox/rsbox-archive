import io.rsbox.toolbox.deobfuscator.asm.ClassPool
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.*
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarOutputStream

fun ClassPool.readJar(file: File) {
    JarFile(file).use { jar ->
        jar.entries().asSequence().forEach { entry ->
            if(entry.name.endsWith(".class")) {
                val node = readClass(jar.getInputStream(entry).readAllBytes())
                this.addClass(node)
            }
        }
    }
}

fun ClassPool.writeJar(file: File) {
    if(file.exists()) {
        file.deleteRecursively()
    }

    JarOutputStream(FileOutputStream(file)).use { jos ->
        this.allClasses.forEach { cls ->
            jos.putNextEntry(JarEntry(cls.name + ".class"))
            jos.writeClass(cls)
            jos.closeEntry()
        }
    }
}

fun readClass(data: ByteArray): ClassNode {
    val node = ClassNode()
    val reader = ClassReader(data)
    reader.accept(node, ClassReader.SKIP_FRAMES)
    return node
}

fun OutputStream.writeClass(node: ClassNode) {
    val writer = ClassWriter(ClassWriter.COMPUTE_MAXS)
    node.accept(writer)
    this.write(writer.toByteArray())
}


fun AbstractInsnNode.isInstruction(): Boolean = this !is LineNumberNode && this !is FrameNode && this !is LabelNode

fun AbstractInsnNode.next(amount: Int): AbstractInsnNode {
    var cur = this
    repeat(amount) {
        cur = cur.next
    }
    return cur
}

fun AbstractInsnNode.previous(amount: Int): AbstractInsnNode {
    var cur = this
    repeat(amount) {
        cur = cur.previous
    }
    return cur
}

fun AbstractInsnNode.isTerminating(): Boolean = when(this.opcode) {
    Opcodes.RETURN,
    Opcodes.ARETURN,
    Opcodes.IRETURN,
    Opcodes.FRETURN,
    Opcodes.DRETURN,
    Opcodes.LRETURN,
    Opcodes.ATHROW,
    Opcodes.TABLESWITCH,
    Opcodes.LOOKUPSWITCH,
    Opcodes.GOTO -> true
    else -> false
}

fun InsnList.copy(): InsnList {
    val newInsnList = InsnList()
    var insn = this.first
    while(insn != null) {
        newInsnList.add(insn)
        insn = insn.next
    }
    return newInsnList
}

fun InsnList.clone(): InsnList {
    val newInsnList = InsnList()
    val labels = LabelMap()
    var insn = this.first
    while(insn != null) {
        newInsnList.add(insn.clone(labels))
        insn = insn.next
    }
    return newInsnList
}

inline fun <reified T : AbstractInsnNode> Collection<AbstractInsnNode>.findFirst(): AbstractInsnNode {
    this.forEach { insn ->
        if(insn::class == T::class) {
            return insn
        }
    }
    throw NullPointerException()
}

class LabelMap : AbstractMap<LabelNode, LabelNode>() {
    private val map = hashMapOf<LabelNode, LabelNode>()
    override val entries get() = throw IllegalStateException()
    override fun get(key: LabelNode) = map.getOrPut(key) { LabelNode() }
}