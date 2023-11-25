package com.github.ked4ma.atcoder.abc263_na

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    val map = mutableMapOf<Int, Int>()
    nextIntList().forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }
    println(if (map.size == 2 && map.all { it.value in 2..3 }) "Yes" else "No")
}
