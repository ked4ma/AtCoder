package com.github.ked4ma.atcoder.abc059_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val a = next()
    val b = next()
    val ans = when {
        a.length > b.length -> "GREATER"
        a.length < b.length -> "LESS"
        a == b -> "EQUAL"
        else -> {
            var comp = "GREATER"
            for (i in a.indices) {
                if (a[i] > b[i]) {
                    comp = "GREATER"
                    break
                } else if (a[i] < b[i]) {
                    comp = "LESS"
                    break
                }
            }
            comp
        }
    }
    println(ans)
}
