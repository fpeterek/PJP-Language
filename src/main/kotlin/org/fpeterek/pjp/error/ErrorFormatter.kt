package org.fpeterek.pjp.error

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import kotlin.math.max
import kotlin.math.min

object ErrorFormatter {

    private const val maxLen = 41
    private const val halfLen = maxLen/2
    private const val tildes = 4

    private fun getErrorLines() = ErrorReporter.errors.map { it.row }.toSortedSet().toList()

    private fun loadErrorLines(filename: String): Map<Int, String> {

        val errorLines = getErrorLines()
        var line = 0
        val errorIterator = errorLines.listIterator()
        var nextError = errorIterator.next()

        val map = mutableMapOf<Int, String>()

        BufferedReader(FileReader(File(filename))).use { reader ->
            reader.forEachLine {
                if (++line == nextError) {
                    map[line] = it
                    if (errorIterator.hasNext()) {
                        nextError = errorIterator.next()
                    } else {
                        return@forEachLine
                    }
                }
            }
        }

        return map
    }

    private fun trimLine(line: String, col: Int): Pair<String, Int> {

        val adjustedCol = col-1
        val errIndex = if (adjustedCol < halfLen) adjustedCol else adjustedCol - halfLen

        val begin = max(0, errIndex - halfLen)
        val end = begin + min(line.length, maxLen)

        return line.substring(begin, end) to errIndex
    }

    private fun formatPtr(ptrIndex: Int): String {

        val lTildes = min(ptrIndex, tildes)
        val beginIndex = max(ptrIndex - lTildes, 0)

        return "${" ".repeat(beginIndex)}${"~".repeat(lTildes)}^${"~".repeat(tildes)}"
    }

    private fun formatError(error: CompilerError, errorLines: Map<Int, String>): Pair<String, String> {

        val (trimmed, idx) = trimLine(errorLines[error.row] ?: "", error.col)

        return trimmed to formatPtr(idx)
    }

    fun reportErrors(filename: String) {

        val errLines = loadErrorLines(filename)

        ErrorReporter.errors.forEach {
            val (line, ptr) = formatError(it, errLines)
            println(it.msg)
            println(line)
            println(ptr)
            println()
        }

        println("Total errors found: ${ErrorReporter.errorCount}")

    }

}
