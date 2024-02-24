package com.github.ked4ma.atcoder.abc342

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import java.util.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
data class Data(val l: Long, val d: Long, val k: Long, val c: Long, val A: Int, val B: Int) {
    fun last(limit: Long): Long? {
        if (limit < l + c) return null
        return l + min(k - 1, (limit - l - c) / d) * d
    }
}

fun main() {
    val (N, M) = nextIntList()
    val data = times(M) {
        nextLongList().let {
            Data(
                it[0],
                it[1],
                it[2],
                it[3],
                it[4].toInt() - 1,
                it[5].toInt() - 1,
            )
        }
    }
    val G = sizedArray(N) { mutableListOf<Data>() }
    for (d in data) {
        G[d.B].add(d)
    }

    val queue = PriorityQueue<Pair<Long, Int>> { a, b -> b.first.compareTo(a.first) }
    val ans = sizedLongArray(N, 0)
    queue.add(Long.MAX_VALUE to N - 1)
    ans[N - 1] = Long.MAX_VALUE
    while (queue.isNotEmpty()) {
        val (limit, v) = queue.poll()
        if (ans[v] > limit) continue

        for (u in G[v]) {
            val next = u.A
            val nextTime = u.last(limit) ?: continue
            if (ans[next] < nextTime) {
                ans[next] = nextTime
                queue.add(nextTime to next)
            }
        }
    }
    for (i in 0 until N - 1) {
        if (ans[i] == 0L) {
            println("Unreachable")
        } else {
            println(ans[i])
        }
    }
}