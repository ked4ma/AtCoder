package com.github.ked4ma.atcoder.abc377

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val LR = times(N) {
        val (L, R) = nextIntList()
        L to R
    }.sortedBy { it.second }

    var ans = 0L
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    queue.addAll(LR)
    for (l in 1..M) {
        while (queue.isNotEmpty() && queue.peek().first < l) {
            queue.poll()
        }
        val r = if (queue.isEmpty()) M else queue.peek().second - 1
        if (l > r) continue
        ans += (r - l + 1)
    }
    println(ans)
//    var ans = 0L
//    var l = 1
//    var r = 1
//    for ((L, R) in LR) {
//        val end = R - 1
//        for (i in l..end) {
//            ans += end - max(i, r) + 1
//        }
//        l = max(l, L + 1)
//        r = end
//    }
//    if (l <= M) {
//        ans += ((M - l + 1L) + 1) * (M - l + 1L) / 2
//    }
//    _debug_println(l)
//    println(ans)
}
