package com.github.khronos227.atcoder.abc060_na

fun main() {
    val (n, T) = nextLongList().let { (n, t) ->
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
