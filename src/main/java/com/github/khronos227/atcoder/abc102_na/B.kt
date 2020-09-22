package com.github.khronos227.atcoder.abc102_na

import kotlin.math.abs

fun main() {
    nextInt()
    nextIntList().let {
        println(abs((it.max() ?: 0) - (it.min() ?: 0)))
    }
}
