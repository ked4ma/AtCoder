package com.github.ked4ma.atcoder.abc361

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextIntList()
    val x1 = N[0] to N[3]
    val y1 = N[1] to N[4]
    val z1 = N[2] to N[5]
    val M = nextIntList()
    val x2 = M[0] to M[3]
    val y2 = M[1] to M[4]
    val z2 = M[2] to M[5]

    val x = min(x2.second - x1.first, x1.second - x2.first)
    val y = min(y2.second - y1.first, y1.second - y2.first)
    val z = min(z2.second - z1.first, z1.second - z2.first)

    println(if (x > 0 && y > 0 && z > 0) "Yes" else "No")
}
