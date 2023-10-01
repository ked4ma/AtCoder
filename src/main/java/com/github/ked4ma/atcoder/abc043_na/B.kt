package com.github.ked4ma.atcoder.abc043_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val s = buildString {
        next().forEach {
            when (it) {
                'B' -> if (length > 0) {
                    deleteCharAt(lastIndex)
                }
                else -> append(it)
            }
        }
    }
    println(s)
}
