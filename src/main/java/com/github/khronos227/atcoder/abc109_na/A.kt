package com.github.khronos227.atcoder.abc109_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (A, B) = nextIntList()
    println(
        if ((A * B) % 2 == 1) {
            "Yes"
        } else {
            "No"
        }
    )
}
