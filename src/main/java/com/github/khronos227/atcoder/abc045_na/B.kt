package com.github.khronos227.atcoder.abc045_na

import com.github.khronos227.atcoder.utils.*
import java.util.*

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
