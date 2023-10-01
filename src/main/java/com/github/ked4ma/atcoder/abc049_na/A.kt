package com.github.ked4ma.atcoder.abc049_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    println(
        when (next()) {
            in arrayOf("a", "i", "u", "e", "o") -> "vowel"
            else -> "consonant"
        }
    )
}
