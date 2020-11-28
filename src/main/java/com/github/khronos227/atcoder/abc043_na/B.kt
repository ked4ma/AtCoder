package com.github.khronos227.atcoder.abc043_na

import com.github.khronos227.atcoder.utils.*

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
