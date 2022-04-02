package com.github.ked4ma.atcoder.arc110

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val len = 3 * 10_000_000_000L
    val n = nextInt()
    val t = next()

    if (n == 1) {
        println((if (t == "1") 2 else 1) * 10_000_000_000L)
        return
    }

    val reg = Regex("""^((1|11)?0)?(110)*(1|11)?$""")
    if (!reg.matches(t)) {
        println(0)
        return
    }

    val offset = when (t.take(2)) {
        "11" -> 0
        "10" -> 1
        else -> 2
    }
    val lastIndex = when (t.takeLast(2)) {
        "11" -> len - 1
        "10" -> len
        else -> len - 2
    } - n
    println((lastIndex - offset) / 3 + 1)
}
