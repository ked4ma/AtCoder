package com.github.khronos227.atcoder.abc044_na

fun main() {
    val n = nextInt()
    val k = nextInt()
    val x = nextInt()
    val y = nextInt()
    println(if (n >= k) {
        k.times(x) + (n - k).times(y)
    } else {
        n.times(x)
    })
}
