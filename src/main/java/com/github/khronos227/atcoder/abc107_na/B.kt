package com.github.khronos227.atcoder.abc107_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (H, W) = nextIntList()
    val hSet = mutableSetOf<Int>()
    val wSet = mutableSetOf<Int>()

    val data = (0 until H).map { h ->
        next().toCharArray().apply {
            for (w in 0 until W) {
                if (this[w] == '#') return@apply
            }
            hSet.add(h)
        }
    }
    repeat(W) { w ->
        for (h in 0 until H) {
            if (data[h][w] == '#') return@repeat
        }
        wSet.add(w)
    }
    for (h in 0 until H) {
        if (h in hSet) continue
        for (w in 0 until W) {
            if (w in wSet) continue
            print(data[h][w])
        }
        println("")
    }
}
