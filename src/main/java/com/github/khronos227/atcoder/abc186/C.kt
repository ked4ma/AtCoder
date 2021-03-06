package com.github.khronos227.atcoder.abc186

import com.github.khronos227.atcoder.utils.*

fun main() {
    val n = nextInt()
    val sevens = mutableSetOf<Int>()
    (1..n).forEach { it ->
        var i = it
        while (i > 0) {
            if (i % 10 == 7) {
                sevens.add(it)
                break
            }
            i /= 10
        }
        i = it
        while (i > 0) {
            if (i % 8 == 7) {
                sevens.add(it)
                break
            }
            i /= 8
        }
    }
    println(n - sevens.size)
}
