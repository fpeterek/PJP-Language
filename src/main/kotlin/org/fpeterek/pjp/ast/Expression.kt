package org.fpeterek.pjp.ast

open class Expression(parent: Node, type: DataType, nodeType: NodeType)
    : Node(nodeType, type, parent)