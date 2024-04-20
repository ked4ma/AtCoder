package com.github.ked4ma.atcoder.abc350

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.combimation.*
import com.github.ked4ma.atcoder.utils.models.unionfind.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()

    val uf = UnionFind(N)
    val G = sizedArray(N) { mutableListOf<Int>() }
    repeat(M) {
        val (a, b) = nextIntList().map { it - 1 }
        G[a].add(b)
        G[b].add(a)
        uf.unite(a, b)
    }

    var ans = 0L
    uf.categories.mapIndexed { i, c -> c to i }.groupBy(
        keySelector = { (c, _) -> c },
        valueTransform = { (_, i) -> i }
    ).values.forEach { nodes ->
        if (nodes.size > 1) {
            val m = nodes.sumOf {
                G[it].size
            }.div(2).toLong()
            ans += combination(nodes.size.toLong(), 2) - m
        }
    }
    println(ans)
}
