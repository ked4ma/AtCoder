package com.github.ked4ma.atcoder.abc325

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val queue = PriorityQueue<Pair<Long, Long>> { a, b -> a.first.compareTo(b.first) }
    repeat(N) {
        queue.offer(nextLongList().let { (T, D) -> T to D })
    }

    var count = 0
    val remains = PriorityQueue<Long>()
    var time = queue.peek().first
    while (true) {
        if (remains.isEmpty()) {
            if (queue.isEmpty()) break
            time = queue.peek().first
        }
        while (queue.isNotEmpty() && queue.peek().first == time) {
            val (t, d) = queue.poll()
            remains.offer(t + d)
        }
        while (remains.isNotEmpty() && remains.peek() < time) {
            remains.poll()
        }
        if (remains.isNotEmpty()) {
            remains.poll()
            count++
        }
        _debug_println("$time $queue $remains")
        time++
    }

    println(count)
}