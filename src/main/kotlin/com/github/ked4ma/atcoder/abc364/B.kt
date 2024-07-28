package com.github.ked4ma.atcoder.abc364

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    var (h, w) = nextIntList().map { it - 1 }
    val C = times(H) {
        next().toCharArray()
    }
    val X = next().toCharArray()
    fun dir(x: Char): Pair<Int, Int> {
        return when (x) {
            'L' -> 0 to -1
            'R' -> 0 to 1
            'U' -> -1 to 0
            else -> 1 to 0 // D
        }
    }
    for (x in X) {
        val (dh, dw) = dir(x)
        if (h + dh !in range(H) || w + dw !in range(W) || C[h + dh][w + dw] != '.') continue
        h += dh
        w += dw
    }
    println("${h + 1} ${w + 1}")
}
