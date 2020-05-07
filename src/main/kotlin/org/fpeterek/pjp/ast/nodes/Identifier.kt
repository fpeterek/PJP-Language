package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Identifier(parent: Block, type: DataType, val name: String, row: Int, col: Int)
    : Expression(parent, type, NodeType.Identifier, row, col) {

    override fun toString() = name

}