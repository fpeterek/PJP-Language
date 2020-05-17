package org.fpeterek.pjp.codegenerator

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.nodes.*
import java.io.File
import kotlin.Exception

object Generator {

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

    private const val iadd = "add"
    private const val isub = "sub"
    private const val imul = "mul"
    private const val idiv = "div"
    private const val imod = "mod"
    private const val ineg = "uminus"
    private const val icat = "concat"
    private const val iand = "and"
    private const val ior  = "or"
    private const val igt  = "gt"
    private const val ilt  = "lt"
    private const val ieq  = "eq"
    private const val inot = "not"
    private const val ipop = "pop" // Ignore value on stack

    private fun getWriter(filename: String) = File(filename).printWriter()
    
    private fun ternary(operator: TernaryOperator): List<String> {

        val cond = expression(operator.cond).toMutableList()
        val onTrue = expression(operator.onTrue).toMutableList()
        val onFalse = expression(operator.onFalse).toMutableList()

        cond.add(ifjump(onTrue.size + 1))
        onTrue.add(ijump(onFalse.size))

        return cond + onTrue + onFalse
    }

    private fun assign(operator: BinaryOperator): List<String> =
        expression(operator.right) + listOf(
            isave((operator.left as Identifier).name), // Store the value
            iload(operator.left) // Then load it again because = returns a value
        )


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

    private fun topLevelExpression(e: Expression) = expression(e) + listOf(ipop)

    private fun write(node: Write) = node.args.reversed().flatMap {
        expression(it)
    } + listOf(iprint(node.args.size))

    private fun read(node: Read) = node.args.flatMap {
        listOf(
            iread(it.dataType),
            isave(it.name)
        )
    }

    private fun ifStatement(statement: If): List<String> {

        val onTrue = if (statement.onTrue != null) {
            compile(statement.onTrue)
        } else {
            listOf()
        }.toMutableList()

        val onFalse = if (statement.onFalse != null) {
            compile(statement.onFalse)
        } else {
            listOf()
        }

        if (onFalse.isNotEmpty()) {
            onTrue.add(ijump(onFalse.size))
        }

        val bytecode = expression(statement.cond).toMutableList()

        if (onTrue.isNotEmpty()) {
            bytecode.add(ifjump(onTrue.size + 1))
        }

        bytecode.addAll(onTrue)
        bytecode.addAll(onFalse)

        return bytecode
    }

    private fun forStatement(statement: For): List<String> {

        val bytecode = topLevelExpression(statement.init).toMutableList()

        val body = if (statement.body != null) {
            compile(statement.body)
        } else {
            listOf()
        }.toMutableList()

        val cond = expression(statement.cond)

        body.addAll(topLevelExpression(statement.increment))
        body.add(ijump((cond.size + body.size + 2) * -1))

        bytecode.addAll(cond)
        bytecode.add(ifjump(body.size))
        bytecode.addAll(body)

        return bytecode
    }

    private fun block(b: Block): List<String> = b.nodes.flatMap { compile(it) }

    private fun initVar(variable: Var) = listOf(
        when (variable.dataType){
            DataType.Int -> "push I0"
            DataType.Bool -> "push Bfalse"
            DataType.Float -> "push F0.0"
            DataType.String -> "push S"
            else -> throw Exception("Invalid variable type")
        },
        isave(variable.name)
    )

    private fun compile(node: AstNode) = when (node) {
        is Write -> write(node)
        is Read -> read(node)
        is Expression -> topLevelExpression(node)
        is If -> ifStatement(node)
        is For -> forStatement(node)
        is Var -> initVar(node)
        is Block -> block(node)
        else -> throw Exception("Invalid AST Node")
    }


    fun generate(ast: Block, filename: String) {

        val bytecode = compile(ast)
        val writer = getWriter(filename)

        bytecode.forEach {
            writer.println(it)
        }
        writer.flush()
    }

}
