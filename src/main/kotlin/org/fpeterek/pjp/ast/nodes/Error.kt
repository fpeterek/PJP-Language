package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Error(parent: Block, row: Int, col: Int)
    : Expression(parent, DataType.TypeError, NodeType.Error, row, col) {

    override fun toString() = "<<Error>>"
}