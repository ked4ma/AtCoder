package com.github.ked4ma.atcoder.abc371

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.int.d2.*
import com.github.ked4ma.atcoder.utils.array.permutation.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val Mg = nextInt()
    val Eg = times(Mg) {
        val (u, v) = nextIntList().map { it - 1 }
        u to v
    }
    val G = sizedArray(N) { mutableSetOf<Int>() }
    for ((u, v) in Eg) {
        G[u].add(v)
        G[v].add(u)
    }
    val Mh = nextInt()
    val Eh = times(Mh) {
        val (a, b) = nextIntList().map { it - 1 }
        a to b
    }
    val H = sizedArray(N) { mutableSetOf<Int>() }
    for ((a, b) in Eh) {
        H[a].add(b)
        H[b].add(a)
    }
    val A = sized2DIntArray(N, N, 0)
    times(N - 1) { i ->
        val a = nextIntList()
        for (j in i + 1 until N) {
            A[i][j] = a[j - i - 1]
            A[j][i] = a[j - i - 1]
        }
    }
    A.forEach { _debug_println(it.joinToString(" ")) }

    var ans = Long.MAX_VALUE
    val arr = range(N).toList().toIntArray()
    while (true) {
        var score = 0L
        for (i in range(N)) {
            for (j in i + 1 until N) {
                if ((j in G[i] && arr[j] !in H[arr[i]]) || (j !in G[i] && arr[j] in H[arr[i]])) {
                    score += A[arr[i]][arr[j]]
                }
            }
        }
        ans = min(ans, score)
        if (!arr.nextPermutation()) break
    }
    println(ans)
}