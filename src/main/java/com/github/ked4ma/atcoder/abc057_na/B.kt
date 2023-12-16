package com.github.ked4ma.atcoder.abc057_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*
import kotlin.math.abs

fun main() {
    val (n, m) = nextIntList()
    val students = (0 until n).map {
        val (a, b) = nextIntList()
        a to b
    }
    val checkpoints = (0 until m).map {
        val (c, d) = nextIntList()
        c to d
    }
    students.forEach { s ->
        var index = -1
        var value = Int.MAX_VALUE
        checkpoints.forEachIndexed { i, cp ->
            val v = abs(cp.first - s.first) + abs(cp.second - s.second)
            if (value > v) {
                value = v
                index = i
            }
        }
        println(index + 1)
    }
}
