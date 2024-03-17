package com.github.ked4ma.atcoder.abc345

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.boolean.d1.*
import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextIntList()
    val G = sizedArray(N) { mutableListOf<Pair<Int, Int>>() }
    for (i in 1..M) {
        val (u, v) = nextIntList().map { it - 1 }
        G[u].add(v to i)
        G[v].add(u to i)
    }
    var Y = 0
    val ans = mutableListOf<Int>()
    val visited = sizedBooleanArray(N, false)
    val lamp = sizedIntArray(N, 0)
    fun dfs(u: Int) {
        if (visited[u]) return
        visited[u] = true
        for ((v, e) in G[u]) {
            if (visited[v]) continue
            dfs(v)
            if (lamp[v] == 0 && Y < K) {
                Y -= lamp[u] + lamp[v]
                lamp[u] = lamp[u] xor 1
                lamp[v] = lamp[v] xor 1
                Y += lamp[u] + lamp[v]
                ans.add(e)
            }
        }
    }
    for (i in range(N)) {
        if (!visited[i]) dfs(i)
    }

    _debug_println(Y)
    if (Y != K) {
        println("No")
    } else {
        println("Yes")
        println(ans.size)
        println(ans.joinToString(" "))
    }
}