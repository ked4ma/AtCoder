package com.github.ked4ma.atcoder.abc052_na

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.max

fun main() {
    var x = 0
    var ans = x
    next()
    next().forEach {
        when (it) {
            'I' -> {
                x++
                ans = max(ans, x)
            }
            'D' -> x--
        }
    }
    println(ans)
}
