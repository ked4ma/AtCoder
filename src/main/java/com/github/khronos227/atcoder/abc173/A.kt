package com.github.khronos227.atcoder.abc173

fun main() {
    val n = nextInt()
    println(1000.minus(n.rem(1000)).rem(1000))
}
