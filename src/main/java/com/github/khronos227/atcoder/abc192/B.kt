package com.github.khronos227.atcoder.abc192

import com.github.khronos227.atcoder.utils.*

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
