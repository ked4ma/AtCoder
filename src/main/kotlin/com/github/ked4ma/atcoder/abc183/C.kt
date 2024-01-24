package com.github.ked4ma.atcoder.abc183

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (n, k) = nextLongList().let { (n, k) ->
        n.toInt() to k
    }
    val costs = (0 until n).map {
        nextLongList()
    }

    fun dfs(city: Int = 0, visited: Set<Int> = setOf(0), cost: Long = 0L): Int {
        if (visited.size == n) {
            return if (cost + costs[city][0] == k) 1 else 0
        }
        var res = 0
        for (i in 0 until n) {
            if (i in visited) continue
            res += dfs(i, visited + i, cost + costs[city][i])
        }
        return res
    }

    println(dfs())
}
