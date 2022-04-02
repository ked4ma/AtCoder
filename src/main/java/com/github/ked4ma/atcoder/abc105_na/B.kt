package com.github.ked4ma.atcoder.abc105_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    var n = nextInt()
    while (n >= 0) {
        if (n % 7 == 0) {
            println("Yes")
            return
        }
        n -= 4
    }
    println("No")
}
