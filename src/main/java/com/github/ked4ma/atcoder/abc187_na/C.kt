package com.github.ked4ma.atcoder.abc187_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    val normalSet = mutableSetOf<String>()
    val exSet = mutableSetOf<String>()
    repeat(nextInt()) {
        val s = next()
        if (s[0] == '!') {
            exSet.add(s.substring(1))
        } else {
            normalSet.add(s)
        }
    }
    for (s in normalSet) {
        if (s in exSet) {
            println(s)
            return
        }
    }
    println("satisfiable")
}
