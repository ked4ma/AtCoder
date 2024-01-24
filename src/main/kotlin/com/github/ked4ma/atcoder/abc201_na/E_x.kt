package com.github.ked4ma.atcoder.abc201_na

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    val n = nextInt()
    val edge = Array(n + 1) { mutableListOf<Int>() }
    val weight = Array(n + 1) { mutableListOf<Long>() }
    for (i in 1 until n) {
        val (u, v, w) = nextLongList()
            .let { (u, v, w) -> Triple(u.toInt(), v.toInt(), w) }
        edge[u].add(v)
        edge[v].add(u)
        weight[u].add(w)
        weight[v].add(w)
    }
    val dist = sizedArray(n + 1, -1L)
    dist[1] = 0
    val queue = ArrayDeque<Int>()
    queue.add(1)
    while (queue.isNotEmpty()) {
        val now = queue.removeFirst()
        for (i in 0 until edge[now].size) {
            val next = edge[now][i]
            if (dist[next] == -1L) {
                dist[next] = dist[now] xor weight[now][i]
                queue.add(next)
            }
        }
    }
    val mod = 1_000_000_007L
    var ans = 0L
    for (i in 0 until 60) {
        val count = arrayOf(0, 0)
        for (j in 0 until n) {
            count[(dist[j + 1] shr i and 1L).toInt()]++
        }
        ans += (1L shl i) % mod * count[0] % mod * count[1]
        ans %= mod
    }
    println(ans)
}
