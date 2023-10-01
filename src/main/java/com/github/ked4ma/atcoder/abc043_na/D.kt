package com.github.ked4ma.atcoder.abc043_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val s = next()
    (0 until s.lastIndex).forEach { i ->
        when {
            s[i] == s[i + 1] -> {
                println("${i + 1} ${i + 2}")
                return
            }
            i < s.lastIndex - 1 && s[i] == s[i + 2] -> {
                println("${i + 1} ${i + 3}")
                return
            }
        }
    }
    println("-1 -1")
}
