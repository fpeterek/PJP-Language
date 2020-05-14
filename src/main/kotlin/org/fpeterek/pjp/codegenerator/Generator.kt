package org.fpeterek.pjp.codegenerator

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.nodes.*
import java.io.File
import java.lang.Exception

class Generator {

    private val typeMapping = mapOf(
        "boolean" to "B",
        "int"     to "I",
        "String"  to "S",
        "float"   to "F"
    )

    private fun ipush(value: Literal) = "push ${typeMapping[value.dataType.value]}${value.value}"
    private fun iload(variable: Identifier) = "load ${variable.name}"
    private fun isave(id: String) = "save $id"
    private fun ijump(distance: Int) = "jmp $distance"
    private fun ifjump(distance: Int) = "fjmp $distance"
    private fun iprint(count: Int) = "print $count"
    private fun iread(type: DataType) = "read ${typeMapping[type.value]}"

    private val iadd = "add"
    private val isub = "sub"
    private val imul = "mul"
    private val idiv = "div"
    private val imod = "mod"
    private val ineg = "uminus"
    private val icat = "concat"
    private val iand = "and"
    private val ior  = "or"
    private val igt  = "gt"
    private val ilt  = "lt"
    private val ieq  = "eq"
    private val inot = "not"

    private fun getWriter(filename: String) = File(filename).printWriter()

    private val bytecode = mutableListOf<String>()
    
    private fun ternary(operator: TernaryOperator) = listOf<String>()

    private fun assign(operator: BinaryOperator): List<String> =
        expression(operator.right) + listOf(isave((operator.left as Identifier).name))

    private fun binaryExpr(operator: BinaryOperator): List<String> =
        expression(operator.right) + expression(operator.left) +
            when (operator.operator) {
                "==" -> listOf(ieq)
                "<"  -> listOf(ilt)
                ">"  -> listOf(igt)
                "<=" -> listOf(igt, inot)
                ">=" -> listOf(ilt, inot)
                "!=" -> listOf(ieq, inot)
                "||" -> listOf(ior)
                "&&" -> listOf(iand)
                "+"  -> listOf(iadd)
                "-"  -> listOf(isub)
                "."  -> listOf(icat)
                "*"  -> listOf(imul)
                "/"  -> listOf(idiv)
                "%"  -> listOf(imod)
                else -> throw Exception("Invalid operator")
            }

    private fun binary(operator: BinaryOperator) = if (operator.operator == "=") {
        assign(operator)
    } else {
        binaryExpr(operator)
    }

    private fun unary(operator: UnaryOperator): List<String> =
        expression(operator.expr) +
            when (operator.operator) {
                "-" -> listOf(ineg)
                "!"  -> listOf(inot)
                else -> throw Exception("Invalid operator")
            }

    private fun varAccess(variable: Identifier) = listOf(iload(variable))
    private fun literal(value: Literal) = listOf(ipush(value))

    private fun expression(e: Expression) = when (e) {
        is Identifier -> varAccess(e)
        is Literal -> literal(e)
        is BinaryOperator -> binary(e)
        is UnaryOperator -> unary(e)
        is TernaryOperator -> ternary(e)
        else -> throw Exception("Not an expression")
    }

    private fun write(node: Write) = node.args.reversed().flatMap {
        expression(it)
    } + listOf(iprint(node.args.size))

    private fun read(node: Read) = node.args.flatMap {
        listOf(
            iread(it.dataType),
            isave(it.name)
        )
    }


    fun generate(ast: Block, filename: String) {




    }

}
