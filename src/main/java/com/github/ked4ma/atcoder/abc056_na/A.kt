package com.github.ked4ma.atcoder.abc056_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (a, b) = nextList().map {
        it == "H"
    }
    println(
        if (!(a xor b)) {
            "H"
        } else {
            "D"
        }
    )
}
