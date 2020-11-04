package com.github.khronos227.atcoder.abc056_na

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
