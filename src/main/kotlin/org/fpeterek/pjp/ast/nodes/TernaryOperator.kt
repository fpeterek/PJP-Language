package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class TernaryOperator(parent: Block, type: DataType, nodeType: NodeType,
                      val cond: Expression, val onTrue: Expression, val onFalse: Expression)
    : Expression(parent, type, nodeType) {

    override fun toString() = "($cond) ? ($onTrue) : ($onFalse)"

}
