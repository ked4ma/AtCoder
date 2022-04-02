package com.github.ked4ma.atcoder.abc103_na

import com.github.ked4ma.atcoder.utils.*

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
