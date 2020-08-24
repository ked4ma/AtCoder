package com.github.khronos227.atcoder.abc176

fun main() {
    val n = next()
    println(if (n.map {
        it.toInt() - 48
    }.sum() % 9 == 0) {
        "Yes"
    } else {
        "No"
    })
}
