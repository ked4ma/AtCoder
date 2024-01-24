package com.github.ked4ma.atcoder.abc187_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*
import kotlin.math.max

fun main() {
    fun s(num: Int): Int {
        var sum = 0
        var n = num
        while (n > 0) {
            sum += n % 10
            n /= 10
        }
        return sum
    }
    val (A, B) = nextIntList()
    println(max(s(A), s(B)))
}
