package com.github.ked4ma.atcoder.abc106_na

import com.github.ked4ma.atcoder.utils.array.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (n, m, q) = nextIntList()
    val x = sized2DArray(n + 1, n + 1, 0)
    repeat(m) {
        val (l, r) = nextIntList()
        x[l][r]++
    }

    val accum = sized2DArray(n + 1, n + 1, 0)
    for (i in 1..n) {
        for (j in 1..n) {
            accum[i][j] = accum[i][j - 1] + x[i][j]
        }
    }
    repeat(q) {
        val (l, r) = nextIntList()
        var sum = 0
        for (i in l..r) {
            sum += accum[i][r] - accum[i][l - 1]
        }
        println(sum)
    }
}
