package com.github.khronos227.atcoder.abc056_na

import com.github.khronos227.atcoder.utils.*

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
