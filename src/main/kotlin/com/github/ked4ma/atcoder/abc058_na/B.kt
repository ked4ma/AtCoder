package com.github.ked4ma.atcoder.abc058_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val o = next()
    val e = next()

    val ans = CharArray(o.length + e.length)
    o.forEachIndexed { index, c ->
        ans[2 * index] = c
    }
    e.forEachIndexed { index, c ->
        ans[2 * index + 1] = c
    }
    println(ans.joinToString(""))
}
