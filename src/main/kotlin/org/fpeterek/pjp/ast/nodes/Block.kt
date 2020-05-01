package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Block(parent: AstNode?) : AstNode(NodeType.Block, DataType.Unit, parent) {

    private val subnodes = mutableListOf<AstNode>()
    private val scopeVariables = mutableListOf<Pair<String, DataType>>()

    val nodes: List<AstNode>
        get() = subnodes


    fun addNode(node: AstNode) {
        if (node.nodeType == NodeType.Var) {
            node as Var
            scopeVariables.add(node.name to node.dataType)
        }
        subnodes.add(node)
    }

}