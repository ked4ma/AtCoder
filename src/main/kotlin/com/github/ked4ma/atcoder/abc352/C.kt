package com.github.ked4ma.atcoder.abc352

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val G = times(N) {
        val (A, B) = nextLongList()
        A to B
    }
    val allShoulderHeight = G.sumOf { (a, _) -> a }
    var ans = 0L
    for ((a, b) in G) {
        ans = max(ans, allShoulderHeight - a + b)
    }
    println(ans)
}
