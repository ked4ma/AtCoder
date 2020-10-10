package com.github.khronos227.atcoder.abc049_na

fun main() {
    println(
        when (next()) {
            in arrayOf("a", "i", "u", "e", "o") -> "vowel"
            else -> "consonant"
        }
    )
}
