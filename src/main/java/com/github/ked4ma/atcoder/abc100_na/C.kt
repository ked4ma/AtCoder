package com.github.ked4ma.atcoder.abc100_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    var count = 0
    nextInt()
    nextIntList().forEach {
        var num = it
        while (num % 2 == 0) {
            num /= 2
            count++
        }
    }
    println(count)
}
