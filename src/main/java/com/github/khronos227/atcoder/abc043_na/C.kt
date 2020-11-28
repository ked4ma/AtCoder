package com.github.khronos227.atcoder.abc043_na

import com.github.khronos227.atcoder.utils.*
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
