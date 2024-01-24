package com.github.ked4ma.atcoder.abc176

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.max

fun main() {
    val (_, _, M) = nextIntList()
    var maxH = 0
    var maxW = 0
    val countH = mutableMapOf<Int, Int>()
    val countW = mutableMapOf<Int, Int>()

    val input = (0 until M).map {
        val (h, w) = nextIntList()
        val valH = countH.getOrDefault(h, 0) + 1
        val valW = countW.getOrDefault(w, 0) + 1
        maxH = max(maxH, valH)
        maxW = max(maxW, valW)
        countH[h] = valH
        countW[w] = valW
        h to w
    }.toSet()
    val targetH = countH.filterValues { it == maxH }.keys
    val targetW = countW.filterValues { it == maxW }.keys
    val result = maxH + maxW - 1
    targetH.forEach { h ->
        targetW.forEach { w ->
            if (!input.contains(h to w)) {
                println(result + 1)
                return
            }
        }
    }
    println(result)
}
