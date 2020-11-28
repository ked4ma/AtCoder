package com.github.khronos227.atcoder.abc046_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val s = next()
    val p = s.filter { it == 'p' }.length
    println(s.length / 2 - p)
}
