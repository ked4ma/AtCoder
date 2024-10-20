package com.github.ked4ma.atcoder.abc376

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.boolean.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (N, M) = nextIntList()
    val G = sizedArray(N) { mutableListOf<Int>() }
    repeat(M) {
        val (a, b) = nextIntList().map { it - 1 }
        G[a].add(b)
    }
    val vis = sizedBooleanArray(N, false)
    vis[0] = true
    var ans = 1
    var target = setOf(0)
    while (target.isNotEmpty()) {
        val next = mutableSetOf<Int>()

        for (u in target) {
            for (v in G[u]) {
                if (v == 0) {
                    println(ans)
                    return
                }
                if (vis[v]) continue
                vis[v] = true
                next.add(v)
            }
        }

        target = next
        ans++
    }
    println(-1)
}
