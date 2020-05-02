package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

abstract class AstNode(val nodeType: NodeType, val dataType: DataType, val parent: Block?)
