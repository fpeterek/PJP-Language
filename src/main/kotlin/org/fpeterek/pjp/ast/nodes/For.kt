package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class For(parent: Block, val init: Expression, val cond: Expression, val increment: Expression,
          val body: AstNode?)
    : AstNode(NodeType.For, DataType.Unit, parent) {

    private val header: String
        get() = "for ($init; $cond; $increment)"

    override fun toString() = if (body == null) {
        "$header;"
    } else {
        "$header\n$body"
    }

    fun toString(indent: Int): String {

        val sb = StringBuilder()

        sb.append(" ".repeat(indent)).append(header)

        if (body == null) {
            sb.append(";")
            return sb.toString()
        }

        sb.append("\n")

        if (body is Block) {
            sb.append(body.toString(indent))
        } else {
            sb.append(" ".repeat(indent+4)).append(body).append(';')
        }

        return sb.append("\n").toString()
    }

}
