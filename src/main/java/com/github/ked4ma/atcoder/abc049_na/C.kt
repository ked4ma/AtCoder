package com.github.ked4ma.atcoder.abc049_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val s = next()
    var right = s.length
    loop@ while (
        true
    ) {
        right -= when {
            right - 5 >= 0 && s.substring(right - 5, right) in arrayOf("dream", "erase") -> 5
            right - 6 >= 0 && s.substring(right - 6, right) == "eraser" -> 6
            right - 7 >= 0 && s.substring(right - 7, right) == "dreamer" -> 7
            else -> break@loop
        }
    }
    println(if (right == 0) "YES" else "NO")
}
