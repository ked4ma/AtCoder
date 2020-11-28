package com.github.khronos227.atcoder.abc048_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val s = next()
    println(if ((s.length % 2 == 0) xor (s.first() == s.last())) "Second" else "First")
}
