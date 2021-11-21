package com.github.khronos227.atcoder.abc197_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (H, W, X, Y) = nextIntList().let { (h, w, x, y) ->
        listOf(h, w, x - 1, y - 1)
    }
    val data = (0 until H).map {
        next().toCharArray()
    }
    var count = if (data[X][Y] == '.') 1 else 0
    // UP
    var a = X - 1
    while (a >= 0 && data[a][Y] == '.') {
        count++
        a--
    }
    // DOWN
    a = X + 1
    while (a < H && data[a][Y] == '.') {
        count++
        a++
    }
    // LEFT
    a = Y - 1
    while (a >= 0 && data[X][a] == '.') {
        count++
        a--
    }
    // RIGHT
    a = Y + 1
    while (a < W && data[X][a] == '.') {
        count++
        a++
    }
    println(count)
}
