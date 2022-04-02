package com.github.ked4ma.atcoder.abc051_na

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.min

fun main() {
    val (n, m) = nextIntList()
    val a = sizedArray(m, 0)
    val b = sizedArray(m, 0)
    val c = sizedArray(m, 0)
    val dist = sized2DArray(n, n, 100_000_000)
    repeat(n) {
        dist[it][it] = 0
    }
    repeat(m) {
        val (ta, tb, tc) = nextIntList()
        a[it] = ta - 1
        b[it] = tb - 1
        c[it] = tc

        dist[a[it]][b[it]] = c[it]
        dist[b[it]][a[it]] = c[it]
    }
    // Warshall–Floyd Algorithm
    for (k in (0 until n)) {
        for (i in (0 until n)) {
            for (j in (0 until n)) {
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
            }
        }
    }

    var res = m
    for (i in (0 until m)) {
        var shortest = false
        for (j in (0 until n)) {
            if (dist[j][a[i]] + c[i] == dist[j][b[i]]) shortest = true
        }
        if (shortest) res--
    }
    println(res)
}
