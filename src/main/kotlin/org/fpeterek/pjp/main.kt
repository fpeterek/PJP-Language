package org.fpeterek.pjp

import org.fpeterek.pjp.generated.Parser

fun main() {
    println("Hello, JabbaCC")
    val parser = Parser(System.`in`)
    val tree = parser.Start()

    (0 until tree.jjtGetNumChildren()).forEach {
        val child = tree.jjtGetChild(it)
        println(child)
    }

}
