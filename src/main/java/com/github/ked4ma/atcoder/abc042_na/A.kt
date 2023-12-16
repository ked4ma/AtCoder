package com.github.ked4ma.atcoder.abc042_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*

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
