package com.github.ked4ma.atcoder.abc109_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (H, W) = nextIntList()
    val a = (0 until H).map {
        nextIntList().toTypedArray()
    }.toTypedArray()
    val ans = mutableListOf<String>()
    for (h in (0 until H)) {
        for (w in (0 until W)) {
            if (h == H - 1 && w == W - 1) break

            if (a[h][w] % 2 == 0) continue

            when {
                w < W - 1 -> {
                    ans.add("${h + 1} ${w + 1} ${h + 1} ${w + 2}")
                    a[h][w]--
                    a[h][w + 1]++
                }
                h < H - 1 -> {
                    ans.add("${h + 1} ${w + 1} ${h + 2} ${w + 1}")
                    a[h][w]--
                    a[h + 1][w]++
                }
            }
        }
    }
    a.forEach {
        _debug_println(it.joinToString(","))
    }
    println(ans.size)
    ans.forEach(::println)
}
