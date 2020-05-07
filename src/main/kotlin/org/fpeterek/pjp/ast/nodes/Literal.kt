package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Literal(parent: Block, type: DataType, val value: String, row: Int, col: Int)
    : Expression(parent, type, NodeType.Literal, row, col) {

    override fun toString() = value

}
