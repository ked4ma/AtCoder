package com.github.ked4ma.atcoder.abc181

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val s = next()
    val sCountMap = s.toCharArray().map {
        it - '0'
    }.groupingBy { it }.eachCount()
    val remainsMap = (1..9).map {
        var n = it
        val remains = mutableListOf<Int>()
        while (n % 8 != 0) {
            remains.add(n % 8)
            n = (n % 8) * 10
        }
        it to remains.toList()
    }.toMap()

    fun dfs(depth: Int = 0, selectArr: Array<Int> = sizedArray(10, 0), remain: Int = 0): Boolean {
        if (depth == s.length.coerceAtMost(3)) return remain % 8 == 0
        if (depth == 0) {
            (1..9).forEach { selectArr[it] = 0 }
        }
        for (i in (1..9)) {
            if (i !in sCountMap || sCountMap.getValue(i) == selectArr[i]) continue
            val arr = selectArr.copyOf()
            arr[i]++
            if (dfs(depth + 1, arr, remain + (remainsMap.getValue(i).getOrNull(depth) ?: 0))) {
                return true
            }
        }
        return false
    }

    println(if (dfs()) "Yes" else "No")
}
