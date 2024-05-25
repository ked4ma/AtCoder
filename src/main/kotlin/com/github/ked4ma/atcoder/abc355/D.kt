package com.github.ked4ma.atcoder.abc355

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val C = times(N) {
        val (l, r) = nextIntList()
        l to r
    }.sortedBy { it.first }
    var ans = 0L
    val queue = PriorityQueue<Int>()
    for ((l, r) in C) {
        while (queue.isNotEmpty() && queue.peek() < l) {
            queue.poll()
        }
        ans += queue.size
        queue.offer(r)
    }
    println(ans)
}
