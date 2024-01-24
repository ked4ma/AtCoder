package com.github.ked4ma.atcoder.abc331

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, M, L) = nextLongList()
    val a = nextLongList()
    val b = nextLongList().withIndex().sortedByDescending { it.value }
    val l = timesWithLong(L) {
        val (c, d) = nextLongList()
        c - 1 to d - 1
    }.toSet()
    _debug_println(l)
    val cur = sizedArray(N.toInt(), 0)
    val queue = PriorityQueue<Pair<Long, Long>> { p1, p2 -> // cost, i(of a)
        p2.first.compareTo(p1.first)
    }
    for (i in 0 until N.toInt()) {
        queue.offer(a[i] + b[cur[i]].value to i.toLong())
    }
    while (queue.isNotEmpty()) {
        val (c, i) = queue.poll()
        _debug_println("$i, ${b[cur[i.toInt()]].index} $c")
        if ((i to b[cur[i.toInt()]].index.toLong()) in l) {
            cur[i.toInt()]++
            if (cur[i.toInt()] < M) queue.offer(a[i.toInt()] + b[cur[i.toInt()]].value to i)
        } else {
            println(c)
            break
        }
    }
}