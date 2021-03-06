package com.github.khronos227.atcoder.abc058_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (n, m) = nextIntList()
    val x = nextLongList()
    val y = nextLongList()

    var valueX = 0L
    for (i in 1..n) {
        valueX = valueX.plusMod((2L * i - n - 1).timesMod(x[i - 1]))
    }
    var valueY = 0L
    for (i in 1..m) {
        valueY = valueY.plusMod((2L * i - m - 1).timesMod(y[i - 1]))
    }
    println(valueX.timesMod(valueY))
}
