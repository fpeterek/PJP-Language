package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Literal(parent: AstNode, type: DataType, val value: String)
    : Expression(parent, type, NodeType.Literal)
