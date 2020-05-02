package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Literal(parent: Block, type: DataType, val value: String)
    : Expression(parent, type, NodeType.Literal) {

    override fun toString() = value

}
