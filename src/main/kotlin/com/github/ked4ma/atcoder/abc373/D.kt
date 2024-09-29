package com.github.ked4ma.atcoder.abc373

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.unionfind.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val uf = UnionFind(N)
    val G = sizedArray(N) { mutableListOf<Pair<Int, Long>>() }
    repeat(M) {
        val (u, v, w) = nextLongList().let { (u, v, w) -> Triple(u.toInt() - 1, v.toInt() - 1, w) }
        uf.unite(u, v)
        G[u].add(v to w)
        G[v].add(u to -w)
    }

    val ans = sizedLongArray(N, Long.MIN_VALUE)
    val queue = ArrayDeque<Int>()
    uf.categories.toSet().forEach {
        ans[it] = 0
        queue.add(it)
    }
    while (queue.isNotEmpty()) {
        val u = queue.removeFirst()
        for ((v, w) in G[u]) {
            if (ans[v] != Long.MIN_VALUE) continue
            ans[v] = ans[u] + w
            queue.add(v)
        }
    }
    println(ans.joinToString(" "))
}
