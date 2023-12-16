package com.github.ked4ma.atcoder.abc101_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*
import kotlin.math.log10
import kotlin.math.pow

fun main() {
    fun sunuke(n: Long): Long {
        fun calc(num: Long): Double {
            var sum = 0L
            var m = num
            while (m > 0) {
                sum += m % 10
                m /= 10
            }
            return num.toDouble() / sum
        }

        var sunuke = n
        var minVal = calc(n)

        repeat(log10(n.plus(1).toDouble()).toInt() + 1) {
            val d10 = 10.toDouble().pow(it + 1).toLong()
            val x = d10.times(n.toDouble().div(d10).plus(1).toLong()).minus(1)
            val xVal = calc(x)
            if (minVal > xVal) {
                sunuke = x
                minVal = xVal
            }
        }
        return sunuke
    }

    val k = nextInt()
    var count = 0
    var v = 1L
    do {
        println(v)
        v = sunuke(v + 1)
        count++
    } while (count < k)
}
