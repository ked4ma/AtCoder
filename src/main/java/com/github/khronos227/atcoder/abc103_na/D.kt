package com.github.khronos227.atcoder.abc103_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (_, m) = nextIntList()
    var x = 0
    var count = 0
    (1..m).map {
        val (a, b) = nextIntList()
        a to b
    }.sortedBy { it.second }.forEach { (a, b) ->
        if (x < a) {
            x = b - 1
            count++
        }
    }
    println(count)
}
