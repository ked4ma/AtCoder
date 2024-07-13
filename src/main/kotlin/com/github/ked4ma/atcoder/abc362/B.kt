package com.github.ked4ma.atcoder.abc362

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.int.pow.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val A = nextIntList()
    val B = nextIntList()
    val C = nextIntList()

    val AB = (B[0] - A[0]).pow(2) + (B[1] - A[1]).pow(2)
    val BC = (C[0] - B[0]).pow(2) + (C[1] - B[1]).pow(2)
    val CA = (A[0] - C[0]).pow(2) + (A[1] - C[1]).pow(2)

    println(if (AB + BC == CA || BC + CA == AB || CA + AB == BC)  "Yes" else "No")
}
