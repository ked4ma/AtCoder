package com.github.ked4ma.atcoder.abc061_na

import com.github.ked4ma.atcoder.utils.array.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    data class Edge(val from: Int, val to: Int, val cost: Long)

    fun <T : Comparable<T>> Array<T>.chmin(index: Int, value: T): Boolean {
        if (this[index] > value) {
            this[index] = value
            return true
        }
        return false
    }

    // bellman-ford
    fun bellmanFord(n: Int, graph: List<Edge>) {
        val dist = sizedArray(n, Long.MAX_VALUE)
        dist[0] = 0
        for (loop in 0 until n + 1) {
            var update = false
            for ((from, to, cost) in graph) {
                if (dist[from] == Long.MAX_VALUE) continue
                if (dist.chmin(to, dist[from] + cost)) {
                    update = true
                }
            }
            if (!update) break
        }
        val d = dist.last()
        for ((from, to, cost) in graph) {
            if (dist[from] == Long.MAX_VALUE) continue
            dist.chmin(to, dist[from] + cost)
        }
        println(if (d != dist.last()) "inf" else -dist.last())
    }

    val (n, m) = nextIntList()
    val graph = (0 until m).map {
        nextLongList().let { (a, b, c) ->
            Edge(a.toInt() - 1, b.toInt() - 1, -c)
        }
    }

    bellmanFord(n, graph)
}
