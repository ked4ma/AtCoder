package com.github.khronos227.atcoder.abc042_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val n = nextIntList().sorted()
    println(
        if (n[0] == 5 && n[1] == 5 && n[2] == 7) {
            "YES"
        } else {
            "NO"
        }
    )
}
