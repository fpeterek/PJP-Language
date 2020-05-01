package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

open class Expression(parent: AstNode, type: DataType, nodeType: NodeType)
    : AstNode(nodeType, type, parent)