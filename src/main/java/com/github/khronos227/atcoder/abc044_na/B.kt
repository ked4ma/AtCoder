package com.github.khronos227.atcoder.abc044_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val w = next().toCharArray().sorted()
    var c = w[0]
    var count = 0
    w.forEach {
        when {
            c == it -> count++
            count % 2 == 0 -> {
                c = it
                count = 1
            }
            else -> {
                println("No")
                return
            }
        }
    }
    println(
        if (count % 2 == 0) {
            "Yes"
        } else {
            "No"
        }
    )
}
