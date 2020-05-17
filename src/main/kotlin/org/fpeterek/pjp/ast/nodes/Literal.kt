package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Literal(parent: Block, type: DataType, value: String, row: Int, col: Int)
    : Expression(parent, type, NodeType.Literal, row, col) {

    val value = if (type == DataType.String) {
        value.trim('"')
    } else {
        value
    }

    override fun toString() = value

}
