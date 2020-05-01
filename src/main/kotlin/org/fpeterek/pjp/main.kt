package org.fpeterek.pjp

import org.fpeterek.pjp.ast.AstBuilder
import org.fpeterek.pjp.generated.Parser

fun main() {
    println("Hello, JabbaCC")
    val parser = Parser(System.`in`)
    val tree = parser.Start()

    tree.dump("")

    val builder = AstBuilder()
    val ast = builder.build(tree)

}
