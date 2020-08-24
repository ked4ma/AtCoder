package com.github.khronos227.atcoder.abc176

fun main() {
    val n = nextInt()
    val a = nextIntList()
    var current = a[0]
    var result = 0L
    (1 until n).forEach {
        if (current > a[it]) {
            result += current - a[it]
        } else {
            current = a[it]
        }
    }
    println(result)
}
