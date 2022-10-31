package io.rsbox.toolbox.updater.classifier

import io.rsbox.toolbox.asm.tree.ClassPool
import io.rsbox.toolbox.updater.classifier.ClassifierUtil.classifier
import org.jgrapht.alg.matching.KuhnMunkresMinimalWeightBipartitePerfectMatching
import org.jgrapht.graph.DefaultWeightedEdge
import org.jgrapht.graph.SimpleWeightedGraph
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode
import java.lang.reflect.Modifier

object StaticMethodClassifiers {

    private val classifiers = mutableListOf<Classifier<MethodNode>>()

    fun init() {
        addClassifier("Method Type Check", 10.0, methodTypeCheck)
    }

    private val methodTypeCheck = classifier<MethodNode> { a, b ->
        val mask = ACC_STATIC or ACC_NATIVE or ACC_ABSTRACT
        val resultA = a.access and mask
        val resultB = b.access and mask
        return@classifier 1.0 - Integer.bitCount(resultA xor resultB) / 3.0
    }

    fun match(fromPool: ClassPool, toPool: ClassPool) {
        val fromMethods = fromPool.classes.flatMap { it.methods }.filter { Modifier.isStatic(it.access) }.toSet()
        val toMethods = toPool.classes.flatMap { it.methods }.filter { Modifier.isStatic(it.access) }.toSet()
        val graph = SimpleWeightedGraph<MethodNode, DefaultWeightedEdge>(DefaultWeightedEdge::class.java)

        fromMethods.forEach { graph.addVertex(it) }
        toMethods.forEach { graph.addVertex(it) }

        fromMethods.forEach { from ->
            toMethods.forEach { to ->
                var score = 0.0
                classifiers.forEach { classifier ->
                    score += (classifier.score(from, to) * classifier.weight)
                }
                graph.addEdge(from, to).also { graph.setEdgeWeight(it, score) }
            }
        }

        val alg = KuhnMunkresMinimalWeightBipartitePerfectMatching(graph, fromMethods, toMethods).matching
        println(alg)
    }

    private fun addClassifier(name: String, weight: Double = 1.0, classifier: Classifier<MethodNode>) {
        classifier.name = name
        classifier.weight = weight
        classifiers.add(classifier)
    }
}