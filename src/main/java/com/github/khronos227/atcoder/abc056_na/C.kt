package com.github.khronos227.atcoder.abc056_na

fun main() {
    val x = nextLong()
    var i = 0L
    var sum = 0L

    while (sum < x) {
        sum += ++i
    }

    println(i)
}
