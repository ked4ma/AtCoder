package com.github.khronos227.atcoder.abc058_na

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
