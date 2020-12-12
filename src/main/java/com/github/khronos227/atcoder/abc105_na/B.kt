package com.github.khronos227.atcoder.abc105_na

import com.github.khronos227.atcoder.utils.*

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
