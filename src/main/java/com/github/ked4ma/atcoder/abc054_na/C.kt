package com.github.ked4ma.atcoder.abc054_na

import com.github.ked4ma.atcoder.utils.array.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (n, m) = nextIntList()
    val edgeArr = sized2DArray(n, n, 0)
    repeat(m) {
        val (a, b) = nextIntList()
        edgeArr[a - 1][b - 1] = 1
        edgeArr[b - 1][a - 1] = 1
    }

    fun dfs(node: Int, checked: Set<Int>): Int {
        val nextChecked = checked + node
        if (nextChecked.size == n) return 1
        var sum = 0
        for (i in (0 until n)) {
            if (node == i || edgeArr[node][i] == 0 || i in checked) continue
            sum += dfs(i, nextChecked)
        }
        return sum
    }

    println(dfs(0, emptySet()))
}
