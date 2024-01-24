package com.github.ked4ma.atcoder.abc177_na

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.max

fun main() {
    val s = next()
    val t = next()

    var m = 0
    (0..(s.length - t.length)).forEach {
        var count = 0
        t.forEachIndexed { index, c ->
            if (c == s[index + it]) count++
        }
        m = max(m, count)
    }
    println(t.length - m)
}
