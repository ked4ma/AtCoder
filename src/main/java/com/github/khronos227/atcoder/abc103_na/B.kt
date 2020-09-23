package com.github.khronos227.atcoder.abc103_na

fun main() {
    val s = next()
    val t = next()
    println(
        if (t.plus(t).contains(s)) {
            "Yes"
        } else {
            "No"
        }
    )
}
