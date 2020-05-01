package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Var(parent: AstNode, val name: String, type: DataType)
    : AstNode(NodeType.Var, type, parent)