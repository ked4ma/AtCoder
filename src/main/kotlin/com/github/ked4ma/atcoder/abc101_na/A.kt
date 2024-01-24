package com.github.ked4ma.atcoder.abc101_na

import com.github.ked4ma.atcoder.utils.input.default.*

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
