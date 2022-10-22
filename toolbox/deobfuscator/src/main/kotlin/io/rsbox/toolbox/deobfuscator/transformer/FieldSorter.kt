package io.rsbox.toolbox.deobfuscator.transformer

import io.rsbox.toolbox.deobfuscator.Transformer
import io.rsbox.toolbox.deobfuscator.asm.ClassPool
import org.objectweb.asm.Type
import org.objectweb.asm.tree.FieldNode
import org.tinylog.kotlin.Logger
import java.lang.reflect.Modifier

class FieldSorter : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        pool.classes.forEach { cls ->
            cls.fields = cls.fields.sortedWith(fieldComparator)
            count += cls.fields.size
        }

        Logger.info("Sorted $count fields.")
    }

    private val fieldComparator = compareBy<FieldNode> { !Modifier.isStatic(it.access) }
        .thenBy { Modifier.toString(it.access and Modifier.fieldModifiers()) }
        .thenBy { Type.getType(it.desc).className }
        .thenBy { it.name }
}