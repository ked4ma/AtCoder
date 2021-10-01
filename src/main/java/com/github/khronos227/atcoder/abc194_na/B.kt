package com.github.khronos227.atcoder.abc194_na

import com.github.khronos227.atcoder.utils.*
import kotlin.math.max

fun main() {
    var res = 1_000_000_000
    val data = (0 until nextInt()).map {
        nextIntList().let { it[0] to it[1] }
    }
    data.map { it.first }.forEachIndexed { i, a ->
        data.map { it.second }.forEachIndexed { j, b ->
            if (i == j) {
                if (a + b < res) {
                    res = a + b
                }
            } else if (max(a, b) < res) {
                res = max(a, b)
            }
        }
    }
    println(res)
}
