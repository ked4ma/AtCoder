package com.github.khronos227.atcoder.abc043_na

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
