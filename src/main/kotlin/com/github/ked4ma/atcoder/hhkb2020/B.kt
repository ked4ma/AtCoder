package com.github.ked4ma.atcoder.hhkb2020

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (h, w) = nextIntList()
    val m = (0 until h).map {
        next().toCharArray()
    }
    var count = 0
    // land
    (0 until h).forEach { i ->
        (1 until w).forEach { j ->
            if (m[i][j] == '.' && m[i][j - 1] == '.') count++
        }
    }
    // port
    (1 until h).forEach { i ->
        (0 until w).forEach { j ->
            if (m[i][j] == '.' && m[i - 1][j] == '.') count++
        }
    }
    println(count)
}
