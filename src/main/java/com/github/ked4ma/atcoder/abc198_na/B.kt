package com.github.ked4ma.atcoder.abc198_na

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    var N = nextInt()
    while (N >= 10 && N % 10 == 0) {
        N /= 10
    }
    println(
        if (N.toString().let { it == it.reversed() }) {
            "Yes"
        } else {
            "No"
        }
    )
}
