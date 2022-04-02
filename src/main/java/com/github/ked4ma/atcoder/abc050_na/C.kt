package com.github.ked4ma.atcoder.abc050_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val mod = 1_000_000_007L
    val n = nextInt()
    val arr = nextIntList().sorted()
    var index = 0

    var count = 1L
    if (n % 2 == 1) {
        if (arr[0] == 0) {
            index = 1
        } else {
            println(0)
            return
        }
    }
    while (index + 1 <= arr.lastIndex) {
        val v = index + 1
        if (arr[index] == v && arr[index + 1] == v) {
            count = count.times(2, mod)
        } else {
            break
        }
        index += 2
    }
    println(
        if (index == arr.size) {
            count
        } else {
            0
        }
    )
}
