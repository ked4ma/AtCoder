package com.github.ked4ma.atcoder.abc264_na

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    // catredo -> atcoder
    val atcoder = "atcoder".toCharArray()
    val input = next().toCharArray()
    val arr = input.map { atcoder.indexOf(it) }.toTypedArray()

    var res = 0
    for (i in atcoder.lastIndex downTo 1) {
        for (j in 0 until i) {
            if (arr[j] > arr[j + 1]) {
                val tmp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = tmp
                res++
            }
        }
    }
    _debug_println(arr.map { atcoder[it] }.joinToString(separator = ""))
    println(res)
}
