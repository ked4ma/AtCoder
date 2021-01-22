package com.github.khronos227.atcoder.abc188

import com.github.khronos227.atcoder.utils.*
import kotlin.math.min

fun main() {
    val (N, C) = nextLongList().let { (N, C) -> N.toInt() to C }
    val dataMap = mutableMapOf<Long, Long>()
    repeat(N) {
        val (a, b, c) = nextLongList()
        dataMap[a] = dataMap.getOrDefault(a, 0) + c
        dataMap[b + 1] = dataMap.getOrDefault(b + 1, 0) - c
    }
    val data = dataMap.map { (k, v) -> k to v }.sortedBy { it.first }
    _debug_println(data)
    var ans = 0L
    var (day, current) = data.first()
    for (i in 1 until data.size) {
        val nextDay = data[i].first
        ans += min(current, C) * (nextDay - day)
        day = nextDay
        current += data[i].second
    }
    println(ans)
}
