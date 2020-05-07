package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Var(parent: Block, val name: String, type: DataType, row: Int, col: Int)
    : AstNode(NodeType.Var, type, parent, row, col) {

    override fun toString() = "var $name: $dataType"
}