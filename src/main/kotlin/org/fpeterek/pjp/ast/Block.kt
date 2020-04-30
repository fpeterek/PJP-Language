package org.fpeterek.pjp.ast

class Block(parent: Node?) : Node(NodeType.Block, DataType.Unit, parent) {

    private val subnodes = mutableListOf<Node>()
    private val scopeVariables = mutableListOf<Pair<String, DataType>>()

    val nodes: List<Node>
        get() = subnodes


    fun addNode(node: Node) {
        if (node.nodeType == NodeType.Var) {
            node as Var
            scopeVariables.add(node.name to node.dataType)
        }
        subnodes.add(node)
    }

}