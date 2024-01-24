package com.github.ked4ma.atcoder.abc195_na

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (N, M, Q) = nextIntList()
    val loads = (0 until N).map { _ ->
        val (w, v) = nextLongList()
        w to v
    }.sortedByDescending { it.second }
    val xList = nextLongList()

    fun solve(loads: List<Pair<Long, Long>>, boxes: List<Long>): Long {
        if (boxes.isEmpty()) return 0L
        val arr = sizedArray(boxes.size, 0L)
        LOAD@ for (load in loads) {
            for (bIndex in boxes.indices) {
                if (arr[bIndex] > 0L) continue
                if (load.first <= boxes[bIndex]) {
                    arr[bIndex] = load.second
                    continue@LOAD
                }
            }
        }
        _debug_println(arr.toList())
        return arr.sum()
    }

    repeat(Q) {
        val (L, R) = nextIntList()
        val list = xList.subList(0, L - 1) + xList.subList(R, M)
        _debug_println(list)
        println(solve(loads, list.sorted()))
    }
}
