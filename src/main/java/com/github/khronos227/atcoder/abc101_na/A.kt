package com.github.khronos227.atcoder.abc101_na

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
