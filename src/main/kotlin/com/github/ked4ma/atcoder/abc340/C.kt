package com.github.ked4ma.atcoder.abc340

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextLong()

    val memo = mutableMapOf<Long, Long>()
    fun dfs(n: Long): Long {
        if (n == 1L) return 0L
        if (n in memo) return memo.getValue(n)
        val res = if (n % 2 == 0L) {
            n + 2 * dfs(n / 2)
        } else {
            n + dfs(n / 2) + dfs(n / 2 + 1)
        }
        memo[n] = res
        return res
    }

    println(dfs(N))
}