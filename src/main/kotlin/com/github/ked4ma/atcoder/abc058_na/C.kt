package com.github.ked4ma.atcoder.abc058_na

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.min

fun main() {
    val n = nextInt()
    val charCountMap = next().groupingBy { it }.eachCount().toMutableMap()

    repeat(n - 1) {
        val nCountMap = next().groupingBy { it }.eachCount()
        charCountMap.forEach { (k, v) ->
            val nCount = nCountMap.getOrDefault(k, 0)
            charCountMap[k] = min(v, nCount)
        }
    }

    for (i in ('a'..'z')) {
        repeat(charCountMap.getOrDefault(i, 0)) {
            print(i)
        }
    }
    println()
}
