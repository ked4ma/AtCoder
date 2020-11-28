package com.github.khronos227.atcoder.abc064_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    nextInt()
    println(nextIntList().sorted().let { it.last() - it.first() })
}
