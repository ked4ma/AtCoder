package com.github.khronos227.atcoder.abc178

fun main() {
    val MOD = 1_000_000_007
    val s = nextInt()
    if (s < 3) {
        println(0)
        return
    }
    var a0 = 1L
    var a1 = 0L
    var a2 = 0L
    (3..s).forEach {
        val n = (a0 + a2).rem(MOD)
        a0 = a1
        a1 = a2
        a2 = n
    }
    println(a2)
}
