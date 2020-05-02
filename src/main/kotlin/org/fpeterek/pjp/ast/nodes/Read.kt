package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Read(parent: Block, val args: List<Identifier>)
    : AstNode(NodeType.Read, DataType.Unit, parent)