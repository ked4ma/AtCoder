package com.github.ked4ma.atcoder.abc043_na

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*
import kotlin.math.roundToInt

fun main() {
    nextInt()
    val arr = nextIntList()
    val n = arr.average().roundToInt()
    println(arr.map {
        val a = (it - n)
        a * a
    }.sum())
}
