package com.github.khronos227.atcoder.abc063_na

fun main() {
    val s = next().toCharArray()
    println(
        if (s.size == s.toSet().size) {
            "yes"
        } else {
            "no"
        }
    )
}
