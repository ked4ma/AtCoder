package com.github.ked4ma.atcoder.abc277_na

import com.github.ked4ma.atcoder.utils.array.any.*
import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextLongList()
    val G = sizedArray(2 * N) {
        mutableSetOf<Pair<Long, Long>>() // dest, cost
    }
    loop(M) {
        val (u, v, a) = nextLongList()
        if (a == 1L) {
            G[u - 1].add(v - 1 to 1)
            G[v - 1].add(u - 1 to 1)
        } else {
            G[u - 1 + N].add(v - 1 + N to 1)
            G[v - 1 + N].add(u - 1 + N to 1)
        }
    }
    if (K > 0) {
        nextLongList().forEach {
            G[it - 1].add(it - 1 + N to 0)
            G[it - 1 + N].add(it - 1 to 0)
        }
    }

    val queue = ArrayDeque<Long>()
    queue.addLast(0)
    val costs = sizedArray(2 * N, Long.MAX_VALUE)
    costs[0] = 0
    while (queue.isNotEmpty()) {
        val n = queue.removeFirst()
        G[n].forEach { (next, c) ->
            if (costs[n] + c < costs[next]) {
                costs[next] = costs[n] + c
                if (c == 0L) {
                    queue.addFirst(next)
                } else {
                    queue.addLast(next)
                }
            }
        }
    }
    val ans = min(costs[N - 1], costs[2 * N - 1])
    println(if (ans == Long.MAX_VALUE) -1 else ans)

//    val (N, M, K) = nextLongList()
//    val map = sized2DArray(2, N) { mutableSetOf<Long>() }
//    repeat(M) {
//        val (u, v, a) = nextLongList()
//        map[a][u - 1].add(v - 1)
//        map[a][v - 1].add(u - 1)
//    }
//    val costs = sized2DArray(2, N, Long.MAX_VALUE)
//    // NOTE: 0 <= K <= N
//    val switches = if (K > 0) nextLongList().map { it - 1 }.toSet() else emptySet()
//    val queue = ArrayDeque<Triple<Long, Long, Long>>()
//    queue.addLast(Triple(0L, 0L, 1L))
//    while (queue.isNotEmpty()) {
//        val (n, cost, a) = queue.removeFirst()
//        if (cost >= costs[a][n]) continue
//        costs[a][n] = cost
//        val nodes = map[a][n]
//        nodes.forEach {
//            if (cost + 1 < costs[a][it]) {
//                queue.addLast(Triple(it, cost + 1, a))
//            }
//        }
//        if (n in switches && cost < costs[1 - a][n]) {
//            queue.addFirst(Triple(n, cost, 1 - a))
//        }
//    }
//    val ans = min(costs[0][N - 1], costs[1][N - 1])
//    println(if (ans == Long.MAX_VALUE) -1 else ans)
}