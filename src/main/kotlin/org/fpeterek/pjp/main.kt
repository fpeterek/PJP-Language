package org.fpeterek.pjp

import org.fpeterek.pjp.ast.AstBuilder
import org.fpeterek.pjp.error.ErrorFormatter
import org.fpeterek.pjp.error.ErrorReporter
import org.fpeterek.pjp.generated.Parser
import java.io.FileInputStream
import kotlin.Exception
import kotlin.system.exitProcess

fun compileFile(filename: String) {

    try {

        val parser = Parser(FileInputStream(filename))
        val tree = parser.Start()
        val builder = AstBuilder()
        val ast = builder.build(tree)

        if (ErrorReporter.errorsDetected) {
            ErrorFormatter.reportErrors(filename)
        } else {
            println("Printing AST...")
            println(ast.toString(0))
        }
    } catch (e: Exception) {
        println(e)
    }


}

fun main(args: Array<String>) {

    if (args.isEmpty()) {
        println("Error: No input files supplied")
        exitProcess(1)
    }

    args.forEach { compileFile(it) }

}
