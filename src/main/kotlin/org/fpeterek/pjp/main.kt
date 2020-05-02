package org.fpeterek.pjp

import org.fpeterek.pjp.ast.AstBuilder
import org.fpeterek.pjp.generated.Parser

fun main() {

    println("Input:")

    val parser = Parser(System.`in`)
    val tree = parser.Start()

    val builder = AstBuilder()
    val ast = builder.build(tree)

    println("Printing AST...")

    println(ast.toString(0))

}
