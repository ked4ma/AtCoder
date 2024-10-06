package com.github.ked4ma.atcoder.abc374

import com.github.ked4ma.atcoder.utils.array.permutation.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    data class Line(val a: Double, val b: Double, val c: Double, val d: Double)
    val (N, S, T) = nextIntList()
    val lines = times(N) {
        val (A, B, C, D) = nextDoubleList()
        Line(A, B, C, D)
    }

    val arr = range(N).toList().toIntArray()
    fun dfs(x: Double = 0.0, y: Double = 0.0, i: Int = 0): Double {
        if (i == N) return 0.0

        val (a, b, c, d) = lines[arr[i]]
        val draw = sqrt((c - a).pow(2) + (d - b).pow(2)) / T

        // go to ab -> cd
        val ab = sqrt((a - x).pow(2) + (b - y).pow(2)) / S +
                draw +
                dfs(c, d, i + 1)
        // go to cd -> ab
        val cd = sqrt((c - x).pow(2) + (d - y).pow(2)) / S +
                draw +
                dfs(a, b, i + 1)

        return min(ab, cd)
    }

    var ans = Double.MAX_VALUE
    while (true) {
        ans = min(ans, dfs())

        if (!arr.nextPermutation()) break
    }
    println(ans)
}
