package com.github.ked4ma.atcoder.abc181

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*
import com.github.ked4ma.atcoder.utils.unionfind.*
import kotlin.math.hypot

fun main() {
    val n = nextInt()
    val a = (0 until n).map {
        val (x, y) = nextIntList()
        x to y
    }

    val S = n
    val T = n + 1
    val edge = mutableListOf<Triple<Double, Int, Int>>()
    a.forEachIndexed { index, (_, y) ->
        edge.add(Triple(100.0 + y, index, S))
        edge.add(Triple(100.0 - y, index, T))
    }
    for (i in (0 until n)) {
        val (x1, y1) = a[i]
        for (j in (i + 1 until n)) {
            val (x2, y2) = a[j]
            edge.add(Triple(hypot((x1 - x2).toDouble(), (y1 - y2).toDouble()), i, j))
        }
    }
    edge.sortBy { it.first }
    val uf = UnionFind(n + 2)
    for ((l, i, j) in edge) {
        uf.unite(i, j)
        if (uf.root(S) == uf.root(T)) {
            println(l / 2)
            return
        }
    }
}
