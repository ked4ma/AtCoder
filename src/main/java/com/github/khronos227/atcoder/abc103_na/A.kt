package com.github.khronos227.atcoder.abc103_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val values = nextIntList().sorted()
    println(values.last() - values.first())
}
