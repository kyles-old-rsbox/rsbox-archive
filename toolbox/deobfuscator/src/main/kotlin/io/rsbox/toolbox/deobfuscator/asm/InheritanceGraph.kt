package io.rsbox.toolbox.deobfuscator.asm

class InheritanceGraph(pool: ClassPool) {

    private val nodes = hashMapOf<String, Node>()

    init {
        pool.classes.forEach { cls ->
            val node = nodes.computeIfAbsent(cls.name) { Node(cls.name) }
            if(cls.superName != null) {
                val superClassNode = nodes.computeIfAbsent(cls.superName) { Node(cls.superName) }
                node.addParent(superClassNode)
                superClassNode.addChild(node)
            }
            if(cls.interfaces != null) {
                cls.interfaces.forEach { interf ->
                    val interfNode = nodes.computeIfAbsent(interf) { Node(interf) }
                    node.addParent(interfNode)
                    interfNode.addChild(node)
                }
            }
        }
        nodes.values.forEach { it.computeRelationships() }
    }

    operator fun get(name: String): Node? = nodes[name]

    class Node(val name: String) {

        val directParents = hashSetOf<Node>()
        val directChildren = hashSetOf<Node>()
        val parents = hashSetOf<Node>()
        val children = hashSetOf<Node>()

        val directRelatives get() = hashSetOf<Node>().also {
            it.addAll(directParents)
            it.addAll(directChildren)
        }

        val relatives get() = hashSetOf<Node>().also {
            it.addAll(parents)
            it.addAll(children)
        }

        fun addChild(node: Node) {
            directChildren.add(node)
        }

        fun addParent(node: Node) {
            directParents.add(node)
        }

        fun computeRelationships() {
            val queue = ArrayDeque<Node>()
            queue.addAll(directChildren)
            while(queue.isNotEmpty()) {
                val child = queue.removeFirst()
                children.add(child)
                queue.addAll(child.directChildren)
            }
            queue.addAll(directParents)
            while(queue.isNotEmpty()) {
                val parent = queue.removeFirst()
                parents.add(parent)
                queue.addAll(parent.directParents)
            }
        }

        override fun hashCode(): Int = name.hashCode()
        override fun equals(other: Any?): Boolean = other is Node && other.name == name
        override fun toString(): String = "NODE[class: $name]"
    }
}