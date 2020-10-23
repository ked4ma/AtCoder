package com.github.khronos227.atcoder.abc050_na

fun main() {
    nextInt()
    val ts = nextIntList()
    val sum = ts.sum()
    repeat(nextInt()) {
        val (p, x) = nextIntList()
        println(sum - ts[p - 1] + x)
    }
}
