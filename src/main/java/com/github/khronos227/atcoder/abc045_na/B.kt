package com.github.khronos227.atcoder.abc045_na

import java.util.ArrayDeque

fun main() {
    var current = 0
    val v = arrayOf(
        ArrayDeque(next().toCharArray().toList()),
        ArrayDeque(next().toCharArray().toList()),
        ArrayDeque(next().toCharArray().toList())
    )
    while (!v[current].isEmpty()) {
        current = v[current].poll() - 'a'
    }
    println('a'.plus(current).toUpperCase())
}
