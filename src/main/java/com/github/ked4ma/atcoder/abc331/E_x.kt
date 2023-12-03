package com.github.ked4ma.atcoder.abc331

import com.github.ked4ma.atcoder.utils.array.default.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.*
import com.github.ked4ma.atcoder.utils.loop.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, M, L) = nextLongList()
    val a = nextLongList()
    val b = nextLongList().withIndex().sortedByDescending { it.value }
    val l = times(L) {
        val (c, d) = nextLongList()
        c - 1 to d - 1
    }.toSet()
    _debug_println(l)
    val cur = sizedArray(N, 0L)
    val queue = PriorityQueue<Pair<Long, Long>> { p1, p2 -> // cost, i(of a)
        p2.first.compareTo(p1.first)
    }
    for (i in 0 until N) {
        queue.offer(a[i] + b[cur[i]].value to i)
    }
    while (queue.isNotEmpty()) {
        val (c, i) = queue.poll()
        _debug_println("$i, ${b[cur[i]].index} $c")
        if ((i to b[cur[i]].index.toLong()) in l) {
            cur[i]++
            if (cur[i] < M) queue.offer(a[i] + b[cur[i]].value to i)
        } else {
            println(c)
            break
        }
    }
}