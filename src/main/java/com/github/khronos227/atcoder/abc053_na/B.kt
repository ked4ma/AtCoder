package com.github.khronos227.atcoder.abc053_na

fun main() {
    val s = next()
    var aIndex = -1
    var zIndex = -1
    s.forEachIndexed { index, c ->
        when (c) {
            'A' -> if (aIndex == -1 ) aIndex = index
            'Z' -> zIndex = index
        }
    }
    println(zIndex - aIndex + 1)
}
