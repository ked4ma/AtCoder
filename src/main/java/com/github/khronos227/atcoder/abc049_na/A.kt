package com.github.khronos227.atcoder.abc049_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    println(
        when (next()) {
            in arrayOf("a", "i", "u", "e", "o") -> "vowel"
            else -> "consonant"
        }
    )
}
