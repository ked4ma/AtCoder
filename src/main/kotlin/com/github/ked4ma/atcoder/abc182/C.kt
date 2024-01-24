package com.github.ked4ma.atcoder.abc182

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.min

fun main() {
    val n = next().map { it - '0' }

    fun dfs(index: Int = 0, sum: Int = 0, delCount: Int = 0): Int {
        if (index >= n.size) {
            return if (delCount < n.size && sum % 3 == 0) delCount else Int.MAX_VALUE
        }
        // use
        return min(
            dfs(index + 1, sum + n[index], delCount),
            dfs(index + 1, sum, delCount + 1)
        )
    }

    val result = dfs()
    println(if (result >= n.size) -1 else result)
}
