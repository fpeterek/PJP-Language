package org.fpeterek.pjp

import org.fpeterek.pjp.ast.AstBuilder
import org.fpeterek.pjp.codegenerator.Generator
import org.fpeterek.pjp.error.ErrorFormatter
import org.fpeterek.pjp.error.ErrorReporter
import org.fpeterek.pjp.generated.Parser
import java.io.FileInputStream
import kotlin.Exception
import kotlin.system.exitProcess

fun dotIndex(filename: String) = filename.indexOf('.')

fun outputFileName(filename: String, dotIndex: Int) = when (dotIndex) {
        -1 -> "$filename.pjp"
        else -> "${filename.dropLastWhile { it != '.' }}pjp"
    }

fun outputFileName(filename: String) = outputFileName(filename, dotIndex(filename))

fun compileFile(filename: String) {

    try {

        val parser = Parser(FileInputStream(filename))
        val tree = parser.Start()
        val builder = AstBuilder()
        val ast = builder.build(tree)

        if (ErrorReporter.errorsDetected) {
            ErrorFormatter.reportErrors(filename)
        } else {
            Generator.generate(ast, outputFileName(filename))
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
