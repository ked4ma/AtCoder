package com.github.khronos227.atcoder.abc059_na

import com.github.khronos227.atcoder.utils.*
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val n = nextInt()
    val a = nextIntList()

    fun calc(init: Int): Long {
        var sum = 0L + a[0]
        var ans = 0L
        // check first elem
        if (init * a[0] <= 0) {
            sum = init.toLong()
            ans += abs(a[0]) + 1
        }
        for (i in 1 until n) {
            val next = sum + a[i]
            if (sum * next < 0) {
                sum = next
                continue
            }

            sum = if (sum > 0) {
                -1
            } else { // < 0
                1
            }
            ans += abs(next) + 1
        }
        return ans
    }

    println(min(calc(1), calc(-1)))
}
