package com.github.ked4ma.atcoder.abc060_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (_, T) = nextLongList().let { (n, t) ->
        n.toInt() to t
    }
    val tMap = sortedMapOf<Long, Int>()
    nextLongList().forEach {
        tMap[it] = tMap.getOrDefault(it, 0) + 1
        tMap[it + T] = tMap.getOrDefault(it + T, 0) - 1
    }

    var ans = 0L
    var l = tMap.firstKey()
    var vL = 0
    tMap.forEach { (k, v) ->
        val next = vL + v
        when {
            vL == 0 && next > 0 -> {
                l = k
            }

            next == 0 -> {
                ans += k - l
            }
        }
        vL = next
    }

    println(ans)
}
