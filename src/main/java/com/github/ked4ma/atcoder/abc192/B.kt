package com.github.ked4ma.atcoder.abc192

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val S = next()
    for (i in S.indices) {
        val isLower = S[i].isLowerCase()
        when {
            i % 2 == 0 -> {
                if (!isLower) {
                    println("No")
                    return
                }
            }

            else -> {
                if (isLower) {
                    println("No")
                    return
                }
            }
        }
    }
    println("Yes")
}
