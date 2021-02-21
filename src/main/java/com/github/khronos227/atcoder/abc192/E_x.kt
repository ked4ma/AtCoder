package com.github.khronos227.atcoder.abc192

import com.github.khronos227.atcoder.utils.*
import java.util.*

fun main() {
    val (N, M, X, Y) = nextIntList()

    data class Path(val from: Int, val to: Int, val cost: Long, val interval: Long)

    val tmpTrains = mutableMapOf<Int, MutableList<Path>>()
    repeat(M) {
        val (A, B, T, K) = nextLongList()
        val a = (A - 1).toInt()
        val b = (B - 1).toInt()
        tmpTrains.getOrDefault(a, mutableListOf()).let { paths ->
            paths.add(Path(a, b, T, K))
            tmpTrains.put(a, paths)
        }
        tmpTrains.getOrDefault(b, mutableListOf()).let { paths ->
            paths.add(Path(b, a, T, K))
            tmpTrains.put(b, paths)
        }
    }
    val trains = tmpTrains.mapValues { it.value.toList() }

//    val costs = sizedArray(N, -1L)
//    costs[X - 1] = 0
//    val queue = ArrayDeque<Path>(trains.getOrDefault(X - 1, emptyList()))
//    while (queue.isNotEmpty()) {
//        val (from, to, cost, interval) = queue.pop()
//        val current = costs[from]
//        val next = current + (interval - current % interval) % interval + cost
//        _debug_println("${from + 1} ${to + 1} $current $next")
//        if (costs[to] < 0 || next < costs[to]) {
//            costs[to] = next
//            queue.addAll(trains.getOrDefault(to, emptyList()))
//        }
//    }
//    _debug_println(costs.joinToString(", "))
//    println(costs[Y - 1])

    // dijkstra
    val vis = sizedArray(N, false)
    val d = sizedArray(N, Long.MAX_VALUE)
    val que = PriorityQueue<Pair<Long, Int>>(compareBy { it.first })
    d[X - 1] = 0
    que.add(0L to X - 1)
    while (que.isNotEmpty()) {
        val q = que.poll()

        val cost = q.first
        val cu = q.second
        if (cu == Y - 1) {
            _debug_println(d.joinToString(","))
            println(cost)
            return
        }
        if (vis[cu]) continue
        vis[cu] = true

        trains[cu]?.forEach { p ->
            val next = cost + (p.interval - cost % p.interval) % p.interval + p.cost
            if (next < d[p.to]) {
                _debug_println("$cu ${p.to} ${p.interval} ${p.cost} $next")
                d[p.to] = next
                que.add(next to p.to)
            }
        }
    }
    println(-1)
}
