package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class TernaryOperator(parent: Block, type: DataType, nodeType: NodeType,
                      val cond: Expression, val onTrue: Expression, val onFalse: Expression,
                      row: Int, col: Int)
    : Expression(parent, type, nodeType, row, col) {

    override fun toString() = "($cond) ? ($onTrue) : ($onFalse)"

}
