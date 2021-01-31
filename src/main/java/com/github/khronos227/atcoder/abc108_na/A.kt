package com.github.khronos227.atcoder.abc108_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val K = nextInt()
    if (K % 2 ==0) { // even
        println((K / 2) * (K / 2))
    } else { // odd
        println((K / 2 + 1) * (K / 2))
    }
}
