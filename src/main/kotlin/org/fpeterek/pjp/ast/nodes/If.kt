package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class If(parent: Block, val cond: Expression, val onTrue: AstNode?, val onFalse: AstNode?)
    : AstNode(NodeType.If, DataType.Unit, parent) {

    private val header: String
        get() = "if ($cond)"

    override fun toString(): String {

        if (onTrue == null) {
            return "$header;"
        }

        if (onFalse == null) {
            return "$header\n$onTrue"
        }

        return "$header\n$onTrue\nelse\n$onFalse"

    }

    fun toString(indent: Int): String {

        val sb = StringBuilder()

        sb.append(" ".repeat(indent)).append(header)

        if (onTrue == null) {
            sb.append(";")
            return sb.toString()
        }

        sb.append("\n")

        if (onTrue is Block) {
            sb.append(onTrue.toString(indent))
        } else {
            sb.append(" ".repeat(indent+4)).append(onTrue).append(';')
        }

        sb.append("\n")

        if (onFalse == null) {
            return sb.toString()
        }

        sb.append(" ".repeat(indent)).append("else")

        if (onFalse is Block) {
            sb.append(onFalse.toString(indent))
        } else {
            sb.append(" ".repeat(indent+4)).append(onFalse).append(';')
        }

        return sb.append("\n").toString()
    }

}