package com.github.ked4ma.atcoder.abc333

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.unionfind.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    val uf = UnionFind(N)
    loop(N - 1) {
        val (u, v) = nextLongList()
        if (u != 1L) {
            uf.unite(u - 1, v - 1)
        }
    }
    println(N - uf.categories.groupingBy { it }.eachCount().values.max())
}
//fun main() {
//    val N = nextLong()
//    val G = sizedArray(N + 1) { mutableListOf<Long>() }
//    loop(N - 1) {
//        val (u, v) = nextLongList()
//        G[u].add(v)
//        G[v].add(u)
//    }
//    fun dfs(i: Long, p: Long): Long { // p: parent
//        if (G[i].size == 1) return 1L
//        val next = G[i].sumOf {
//            if (it == p) 0L else {
//                dfs(it, i)
//            }
//        }
//        return next + 1
//    }
//
//    val ans = if (G[1].size == 1) {
//        1L
//    } else {
//        var MAX = Long.MIN_VALUE
//        G[1].sumOf {
//            val v = dfs(it, 1)
//            MAX = max(MAX, v)
//            v
//        } - MAX + 1
//    }
//    println(ans)
//}