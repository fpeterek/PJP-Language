package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Identifier(parent: Block, type: DataType, val name: String)
    : Expression(parent, type, NodeType.Identifier)