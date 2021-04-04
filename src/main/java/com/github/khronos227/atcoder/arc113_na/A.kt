package com.github.khronos227.atcoder.arc113_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val K = nextInt()
    val n = (1..K).map { a ->
        (1..K / a).map { b ->
            K / (a * b)
        }.sum()
    }.sum()
    println(n)
}
