package com.github.ked4ma.atcoder.abc337

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*
import com.github.ked4ma.atcoder.utils.list.*
import com.github.ked4ma.atcoder.utils.models.tree.fenwick.*
import com.github.ked4ma.atcoder.utils.repeat.*
import java.io.PrintWriter

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val a = 0L
    _debug_println((a as Int))
    val N = nextInt()
    val G = Array(N) { mutableListOf<Int>() }
    for (i in 0 until N - 1) {
        val (u, v) = nextIntList().let { (u, v) -> u - 1 to v - 1 }
        G[u].add(v)
        G[v].add(u)
    }
    val bit = FenwickTree(N.toLong())
    val d = LongArray(N) { 0L}
    val dc = Array(N) { mutableListOf<Long>() }
    fun dfs(v: Int, p: Int= -1) {
        bit.add(v, 1)
        d[v] -= bit.sum(0, v)
        for (u in G[v]) {
            dc[v].add(0)
            if (u == p) continue
            dc[v][dc[v].lastIndex] -= bit.sum(0, v)
            dfs(u, v)
            dc[v][dc[v].lastIndex] += bit.sum(0, v)
        }
        d[v] += bit.sum(0, v)
    }
    dfs(0)

    var base = 0L
    for (it in 0 until N) {
        base += d[it]
    }

    val ans = LongArray(N){0L}
    fun dfs2(v: Int, x: Long, p: Int = -1) {
        ans[v] = x
        loop(G[v].size.toLong()) { i ->
            val u = G[v][i]
            if (u == p) return@loop
            var nx = x
            nx -= dc[v][i]
            nx += u - d[u]
            dfs2(u, nx, v)
        }
    }
    dfs2(0, base)

//    println(ans.joinToString(" "))
    PrintWriter(System.out).use {
        for (i in 0 until N) {
            if (i > 0) it.print(' ')
            it.print(ans[i])
        }
        it.println()
    }
}

// NOTE: LTE (outline is fine...)
// fun main() {
//     val N = nextLong()
//     val G = sizedArray(N) { mutableListOf<Long>() }
//     loop(N - 1) {
//         val (u, v) = nextLongList().let { (u, v) -> u - 1 to v - 1 }
//         G[u].add(v)
//         G[v].add(u)
//     }
//
//     var visited = 0L
//     val parent = sizedLongArray(N, -1L)
//     // CHECK POINT (creating 'in' and 'out' corresponding to nodes)
//     val L = sizedLongArray(N, -1L)
//     val R = sizedLongArray(N, -1L)
//
//     // euler tour
//     fun dfs(u: Long, p: Long) {
//         L[u] = visited
//         visited++
//         parent[u] = p
//         for (v in G[u]) {
//             if (v == p) continue
//             dfs(v, u)
//         }
// //        if (p != -1L) {
// //            var i = 0L
// //            while (G[u][i] != p) i++ // find parent node
// //            if (i < G[u].size) {
// //                G[u].removeAt(i.toInt()) // remove parent not to visit again
// //            }
// //        }
// //        for (v in G[u]) dfs(v, u)
//         R[u] = visited
//     }
//     dfs(0, -1)
//
//     val cnt = FenwickTree(N)
//     val seg = LazySegmentTree.of(N, Updater.RAQ, Evaluator.RSQ)
//     for (i in 0 until N) {
//         for (v in G[i]) {
//             if (v == parent[i]) continue
//             val c = cnt.sum(L[v], R[v])
//             seg.update(0, N, c)
//             seg.update(L[v], R[v], -c)
//         }
//         if (parent[i] != -1L) {
//             val c = i - cnt.sum(L[i], R[i])
//             seg.update(L[i], R[i], c)
//         }
//         // for-loop is done from lower value, so i is valid value at next i (i + 1)
//         cnt.add(L[i], 1)
//     }
//
//     PrintWriter(System.out).use {
//         for (i in 0 until N) {
//             if (i > 0) it.print(' ')
//             it.print(seg.query(L[i], L[i] + 1))
//         }
//         it.println()
//     }
//
// //    val sb = StringBuilder(N.toInt() * 10)
// //    for (i in 0 until N) {
// //        if (i > 0) sb.append(' ')
// //        sb.append(seg.query(L[i], L[i] + 1))
// //    }
// //    println(sb.toString())
//
// //    val sj = StringJoiner(" ")
// //    for (i in 0 until N) {
// //        sj.add(seg.query(L[i], L[i] + 1).toString())
// //    }
// //    println(sj.toString())
// }