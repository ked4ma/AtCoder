package com.github.ked4ma.atcoder.hhkb2020

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*
import com.github.ked4ma.atcoder.utils.math.modinv.*

fun main() {
    val mod = 1_000_000_007L
    fun Long.timesMod(x: Long) = this.times(x).rem(mod)
    fun Long.divMod(x: Long) = this.times(modinv(x, mod)).rem(mod)
    fun Long.plusMod(x: Long) = this.plus(x).rem(mod)
    fun Long.minusMod(x: Long) = this.plus(mod).minus(x).rem(mod)

    val (h, w) = nextIntList()
    val map = (0 until h).map {
        next()
    }
    val k = map.sumBy { m -> m.count { it == '.' } }
    var base = 1L
    repeat(k) {
        base = base.timesMod(2)
    }
    var total = k.toLong().timesMod(base)
    val countHArr = sized2DArray(h, w, 0)
    (0 until w).forEach { j ->
        var i = 0
        var count = 0
        while (i < h) {
            if (map[i][j] == '#') {
                repeat(count) {
                    countHArr[i - it - 1][j] = count
                }
                count = 0
            } else {
                count++
            }
            i++
        }
        repeat(count) {
            countHArr[i - it - 1][j] = count
        }
    }
    val countWArr = sized2DArray(h, w, 0)
    (0 until h).forEach { i ->
        var j = 0
        var count = 0
        while (j < w) {
            if (map[i][j] == '#') {
                repeat(count) {
                    countWArr[i][j - it - 1] = count
                }
                count = 0
            } else {
                count++
            }
            j++
        }
        repeat(count) {
            countWArr[i][j - it - 1] = count
        }
    }

    val valueMap = mutableMapOf<Int, Long>()
    (0 until h).forEach { i ->
        (0 until w).forEach inner@{ j ->
            if (map[i][j] == '#') return@inner
            val t = countHArr[i][j] + countWArr[i][j] - 1

            if (t !in valueMap) {
                var subtotal = base
                repeat(t) {
                    subtotal = subtotal.divMod(2)
                }
                valueMap[t] = subtotal
            }
            total = total.minusMod(valueMap.getValue(t))
        }
    }
    println(total)
}
