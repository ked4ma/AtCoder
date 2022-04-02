package com.github.ked4ma.atcoder.abc179

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.max

fun main() {
    var m = 0
    var count = 0
    repeat(nextInt()) {
        val (x, y) = nextIntList()
        if (x == y) {
            count++
        } else {
            m = max(m, count)
            count = 0
        }
    }
    m = max(m, count)
    println(if (m >= 3) "Yes" else "No")
}
