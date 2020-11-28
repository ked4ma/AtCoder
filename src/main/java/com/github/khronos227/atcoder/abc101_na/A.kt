package com.github.khronos227.atcoder.abc101_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    var num = 0
    next().forEach {
        if (it == '+') {
            num++
        } else {
            num--
        }
    }
    println(num)
}
