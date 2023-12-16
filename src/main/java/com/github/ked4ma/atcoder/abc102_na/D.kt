package com.github.ked4ma.atcoder.abc102_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    nextIntList()
    val values = nextLongList()
    var sum = 0L
    val estValues = mutableListOf<Long>().apply {
        values.forEach {
            sum += it
            add(sum)
        }
    }.toList()

    fun separate(l: Int, r: Int, base: Long): Triple<Long, Long, Int> {
        var lVal = estValues[l]
        val mid = estValues[r - 1].plus(base).toDouble().div(2)
        var minDiff = abs(mid - lVal)
        var index = l + 1
        while (index < r && minDiff > abs(mid - estValues[index])) {
            lVal = estValues[index]
            minDiff = abs(mid - lVal)
            index++
        }
        val rVal = estValues[r - 1] - lVal
        lVal -= base
        return if (rVal < lVal) {
            Triple(rVal, lVal, index - 1)
        } else {
            Triple(lVal, rVal, index - 1)
        }
    }

    var res = Long.MAX_VALUE
    var li = 0
    var ri = 2
    (2..values.lastIndex.minus(1)).forEach {
        val (lMin, lMax, nli) = separate(li, it, 0)
        val (rMin, rMax, nri) = separate(ri, values.size, estValues[it - 1])
        val v = abs(max(lMax, rMax) - min(lMin, rMin))
        li = nli
        ri = nri
        res = min(res, v)
    }
    println(res)
}
