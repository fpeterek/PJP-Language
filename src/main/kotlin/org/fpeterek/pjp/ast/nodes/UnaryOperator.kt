package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class UnaryOperator(parent: Block, type: DataType, nodeType: NodeType,
                    val operator: String, val expr: Expression)
    : Expression(parent, type, nodeType) {

    override fun toString() = "$operator($expr)"

}
