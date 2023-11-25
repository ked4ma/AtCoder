package com.github.ked4ma.atcoder.abc326

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList().sorted()
    var ans = 0
    var cur = 0
    val queue = ArrayDeque<Int>()
    A.forEach {
        while (queue.isNotEmpty() && queue.first() <= it) {
            queue.removeFirst()
            cur--
        }
        queue.addLast(it + M)
        ans = max(ans, queue.size)
    }
    println(ans)
}