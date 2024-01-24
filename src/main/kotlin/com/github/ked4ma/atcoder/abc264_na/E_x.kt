package com.github.ked4ma.atcoder.abc264_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.unionfind.*

fun main() {
//    val (N, M, E) = listOf(5, 5, 10)
//    val edges = listOf(
//        2 to 3,
//        4 to 10,
//        5 to 10,
//        6 to 9,
//        2 to 9,
//        4 to 8,
//        1 to 7,
//        3 to 6,
//        8 to 10,
//        1 to 8,
//    ).map { (u, v) ->
//        u.coerceAtMost(N + 1) to v.coerceAtMost(N + 1)
//    }
//    val Q = 6
//    val queries = listOf(
//        3,
//        5,
//        8,
//        10,
//        2,
//        7
//    )
    val (N, M, E) = nextIntList()
    val edges = (0 until E).map {
        nextIntList().let { (u, v) ->
            u.coerceAtMost(N + 1) to v.coerceAtMost(N + 1)
        }
    }
    val Q = nextInt()
    val queries = (0 until Q).map { nextInt() }

    val uf = UnionFind(N + 2)
    val broken = queries.toSet()
    // [NOTE] following filter operation will be a bottleneck for execution
    edges.filterIndexed { index, _ -> !broken.contains(index + 1) }.forEach {
        uf.unite(it.first, it.second)
    }
    val res = mutableListOf<Int>()
    queries.asReversed().forEach {
        res.add(uf.size(N + 1) - 1) // not to include power stations
        val (u, v) = edges[it - 1]
        uf.unite(u, v)
    }
    println(res.asReversed().joinToString(separator = "\n"))
}
