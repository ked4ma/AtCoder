package com.github.ked4ma.atcoder.abc330

import com.github.ked4ma.atcoder.utils.array.any.d2.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = timesWithLong(N.toLong()) {
        next().toCharArray()
    }.toTypedArray()

    val rowLeft = sized2DArray(N, N, 0L)
    val rowRight = sized2DArray(N, N, 0L)
    val colTop = sized2DArray(N, N, 0L)
    val colBottom = sized2DArray(N, N, 0L)
    for (i in 0 until N) {
        for (j in 0 until N) {
            rowLeft[i][j] = if (i > 0) rowLeft[i - 1][j] else 0
            colTop[i][j] = if (j > 0) colTop[i][j - 1] else 0
            if (S[i][j] == 'o') {
                rowLeft[i][j]++
                colTop[i][j]++
            }
        }
    }
    for (i in N - 1 downTo 0) {
        for (j in N - 1 downTo 0) {
            rowRight[i][j] = if (i < N - 1) rowRight[i + 1][j] else 0
            colBottom[i][j] = if (j < N - 1) colBottom[i][j + 1] else 0
            if (S[i][j] == 'o') {
                rowRight[i][j]++
                colBottom[i][j]++
            }
        }
    }

    var count = 0L
    for (i in 0 until N) {
        for (j in 0 until N) {
            if (S[i][j] == 'o') {
                val left = if (i > 0) rowLeft[i - 1][j] else 0
                val right = if (i < N - 1) rowRight[i + 1][j] else 0
                val top = if (j > 0) colTop[i][j - 1] else 0
                val bottom = if (j < N - 1) colBottom[i][j + 1] else 0
                count += (left + right) * (top + bottom)
            }
        }
    }

    println(count)
}