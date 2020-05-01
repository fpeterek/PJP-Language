package org.fpeterek.pjp.ast

import org.fpeterek.pjp.ast.nodes.AstNode
import org.fpeterek.pjp.ast.nodes.Block
import org.fpeterek.pjp.generated.ASTStart
import org.fpeterek.pjp.generated.Node

class AstBuilder {

    private val root = Block(null)
    private var current = root

    private fun enterScope(new: Block) {
        current = new
    }

    private fun getParent(node: AstNode): Block? = if (node.parent == null) {
        null
    } else {
        if (node.parent is Block) node.parent else getParent(node.parent)
    }

    private fun leaveScope() {
        current = getParent(current) ?: root
    }

    private fun handleNode(node: Node) {

    }

    fun build(start: ASTStart): Block {

        (0 until start.jjtGetNumChildren()).forEach {
            val child = start.jjtGetChild(it)
        }

        return root
    }

}