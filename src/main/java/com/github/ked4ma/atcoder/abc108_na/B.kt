package com.github.ked4ma.atcoder.abc108_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    fun rotation(v: Pair<Int, Int>) = -v.second to v.first

    val (x1, y1, x2, y2) = nextIntList()
    val vec12 = (x2 - x1 to y2 - y1)

    val vec23 = rotation(vec12)
    val x3 = x2 + vec23.first
    val y3 = y2 + vec23.second

    val vec34 = rotation(vec23)
    val x4 = x3 + vec34.first
    val y4 = y3 + vec34.second

    println("$x3 $y3 $x4 $y4")
}
