package com.github.ked4ma.atcoder.abc173

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val n = nextInt()
    println(1000.minus(n.rem(1000)).rem(1000))
}
