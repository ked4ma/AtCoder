package com.github.ked4ma.atcoder.abc337

import com.github.ked4ma.atcoder.utils.array.any.*
import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.long.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.tree.fenwick.*
import com.github.ked4ma.atcoder.utils.models.tree.segment.lazy.*
import com.github.ked4ma.atcoder.utils.repeat.*
import java.io.PrintWriter

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]

// NOTE: LTE (outline is fine...)
fun main() {
    val N = nextLong()
    val G = sizedArray(N) { mutableListOf<Long>() }
    loop(N - 1) {
        val (u, v) = nextLongList().let { (u, v) -> u - 1 to v - 1 }
        G[u].add(v)
        G[v].add(u)
    }

    var visited = 0L
    val parent = sizedLongArray(N, -1L)
    // CHECK POINT (creating 'in' and 'out' corresponding to nodes)
    val L = sizedLongArray(N, -1L)
    val R = sizedLongArray(N, -1L)

    // euler tour
    fun dfs(u: Long, p: Long) {
        L[u] = visited
        visited++
        parent[u] = p
        for (v in G[u]) {
            if (v == p) continue
            dfs(v, u)
        }
//        if (p != -1L) {
//            var i = 0L
//            while (G[u][i] != p) i++ // find parent node
//            if (i < G[u].size) {
//                G[u].removeAt(i.toInt()) // remove parent not to visit again
//            }
//        }
//        for (v in G[u]) dfs(v, u)
        R[u] = visited
    }
    dfs(0, -1)

    val cnt = FenwickTree(N)
    val seg = LazySegmentTree.of(N, Updater.RAQ, Evaluator.RSQ)
    for (i in 0 until N) {
        for (v in G[i]) {
            if (v == parent[i]) continue
            val c = cnt.sum(L[v], R[v])
            seg.update(0, N, c)
            seg.update(L[v], R[v], -c)
        }
        if (parent[i] != -1L) {
            val c = i - cnt.sum(L[i], R[i])
            seg.update(L[i], R[i], c)
        }
        // for-loop is done from lower value, so i is valid value at next i (i + 1)
        cnt.add(L[i], 1)
    }

    PrintWriter(System.out).use {
        for (i in 0 until N) {
            if (i > 0) it.print(' ')
            it.print(seg.query(L[i], L[i] + 1))
        }
        it.println()
    }

//    val sb = StringBuilder(N.toInt() * 10)
//    for (i in 0 until N) {
//        if (i > 0) sb.append(' ')
//        sb.append(seg.query(L[i], L[i] + 1))
//    }
//    println(sb.toString())

//    val sj = StringJoiner(" ")
//    for (i in 0 until N) {
//        sj.add(seg.query(L[i], L[i] + 1).toString())
//    }
//    println(sj.toString())
}