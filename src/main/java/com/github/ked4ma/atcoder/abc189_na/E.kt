package com.github.ked4ma.atcoder.abc189_na

import com.github.ked4ma.atcoder.utils.input.buffered.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        PrintWriter(System.out).use { pw ->
            solve(br, pw)
            pw.flush()
        }
    }
}

private fun solve(br: BufferedReader, pw: PrintWriter) {
    val N = nextInt(br)
    val points = (0 until N).map { _ ->
        nextLongList(br).let { (x, y) -> arrayOf(x, y, 1L) }
    }

    val trans = mutableListOf(
        arrayOf(longArrayOf(1L, 0L, 0L), longArrayOf(0L, 1L, 0L), longArrayOf(0L, 0L, 1L))
    )

    fun getTransVec(input: List<Long>) = when (input[0]) {
        1L -> arrayOf(longArrayOf(0L, 1L, 0L), longArrayOf(-1L, 0L, 0L), longArrayOf(0L, 0L, 1L))
        2L -> arrayOf(longArrayOf(0L, -1L, 0L), longArrayOf(1L, 0L, 0L), longArrayOf(0L, 0L, 1L))
        3L -> arrayOf(longArrayOf(-1L, 0L, 2 * input[1]), longArrayOf(0L, 1L, 0L), longArrayOf(0L, 0L, 1L))
        else -> arrayOf(longArrayOf(1L, 0L, 0L), longArrayOf(0L, -1L, 2 * input[1]), longArrayOf(0L, 0L, 1L))
    }
    repeat(nextInt(br)) {
        val input = nextLongList(br)
        val vec0 = trans.last()
        val vec = getTransVec(input)
        val next = arrayOf(longArrayOf(0, 0, 0), longArrayOf(0, 0, 0), longArrayOf(0, 0, 0))
        repeat(3) { x ->
            repeat(3) { y ->
                repeat(3) { i ->
                    next[x][y] += vec[x][i] * vec0[i][y]
                }
            }
        }
        trans.add(next)
    }
    repeat(nextInt(br)) {
        val (A, B) = nextIntList(br)
        val vec = trans[A]
        val point = points[B - 1]
        var x = 0L
        var y = 0L
        repeat(3) { i ->
            x += vec[0][i] * point[i]
            y += vec[1][i] * point[i]
        }
        pw.println("$x $y")
    }
}
