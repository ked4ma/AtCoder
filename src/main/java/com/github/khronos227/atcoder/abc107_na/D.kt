package com.github.khronos227.atcoder.abc107_na

import com.github.khronos227.atcoder.utils.*
import kotlin.math.min

fun main() {
    val N = nextInt()
    val data = nextIntList().sorted()
    println(data[min(N / 2 + 1, data.lastIndex)])
}
