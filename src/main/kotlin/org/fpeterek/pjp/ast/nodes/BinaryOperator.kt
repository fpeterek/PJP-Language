package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class BinaryOperator(parent: Block, type: DataType, nodeType: NodeType,
                     val operator: String, val left: Expression, val right: Expression,
                     row: Int, col: Int)
    : Expression(parent, type, nodeType, row, col) {

    override fun toString() = "$left $operator ($right)"

}
