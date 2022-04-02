package com.github.ked4ma.atcoder.arc113_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (A, B, C) = nextIntList()
    _debug_println("$A $B $C")
    val bc = if (B % 4 == 2) {
        if (C == 1) 2 else 0
    } else {
        val c = if (C % 2 == 0) 2 else 1
        (if (c == 1) B else B * B) % 4
    }
    var a = 1
    repeat(bc + 4) {
        a = (a * (A % 10)) % 10
    }
    println(a)
}
