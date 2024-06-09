package com.github.ked4ma.atcoder.abc357

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.int.pow.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val LEN = 3.pow(N)
    val arr = Array(LEN) { CharArray(LEN) { '.' } }

    fun dfs(l: Int, r: Int, t: Int, b: Int) {
        val n = r - l
        if (n == 1) {
            arr[l][t] = '#'
            return
        }
        val interval = n / 3
        for (i in range(3)) {
            for (j in range(3)) {
                if (i == 1 && j == 1) continue
                dfs(l + i * interval, l + (i + 1) * interval, t + j * interval, t + (j + 1) * interval)
            }
        }
    }
    dfs(0, LEN, 0, LEN)
    println(arr.joinToString("\n") { it.joinToString("") })
}
