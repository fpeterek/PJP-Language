package org.fpeterek.pjp.ast

class Block(parent: Node?) : Node(NodeType.Block, DataType.Unit, parent) {

    private val subnodes = mutableListOf<Node>()

    val nodes: List<Node>
        get() = subnodes

    fun addNode(node: Node) = subnodes.add(node)

}