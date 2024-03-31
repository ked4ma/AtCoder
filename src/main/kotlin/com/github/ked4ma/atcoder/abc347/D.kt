package com.github.ked4ma.atcoder.abc347

import com.github.ked4ma.atcoder.utils.array.long.d3.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.number.long.bit.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (a, b, C) = nextLongList().let { (a, b, c) ->
        Triple(a.toInt(), b.toInt(), c)
    }

    val dpA = sized3DLongArray(61, 61, 61, Long.MAX_VALUE)
    val dpB = sized3DLongArray(61, 61, 61, Long.MAX_VALUE)
    dpA[0][0][0] = 0
    dpB[0][0][0] = 0

    for (i in 1..60) {
        if (C.bit(i - 1)) {
            // x = 0, y = 1
            // x = 1, y = 0
            for (na in 0..60) {
                for (nb in 0..60) {
                    if (na > 0 && dpA[i - 1][na - 1][nb] < Long.MAX_VALUE && dpB[i - 1][na - 1][nb] < Long.MAX_VALUE) {
                        dpA[i][na][nb] = dpA[i - 1][na - 1][nb] or (1L shl (i - 1))
                        dpB[i][na][nb] = dpB[i - 1][na - 1][nb]
                    } else if (nb > 0 && dpA[i - 1][na][nb - 1] < Long.MAX_VALUE && dpB[i - 1][na][nb - 1] < Long.MAX_VALUE) {
                        dpA[i][na][nb] = dpA[i - 1][na][nb - 1]
                        dpB[i][na][nb] = dpB[i - 1][na][nb - 1] or (1L shl (i - 1))
                    }
                }
            }
        } else {
            // x = 0, y = 0
            // x = 1, y = 1
            for (na in 0..60) {
                for (nb in 0..60) {
                    if (dpA[i - 1][na][nb] < Long.MAX_VALUE && dpB[i - 1][na][nb] < Long.MAX_VALUE) {
                        dpA[i][na][nb] = dpA[i - 1][na][nb]
                        dpB[i][na][nb] = dpB[i - 1][na][nb]
                    } else if (na > 0 && nb > 0 && dpA[i - 1][na - 1][nb - 1] < Long.MAX_VALUE && dpB[i - 1][na - 1][nb - 1] < Long.MAX_VALUE) {
                        dpA[i][na][nb] = dpA[i - 1][na - 1][nb - 1] or (1L shl (i - 1))
                        dpB[i][na][nb] = dpB[i - 1][na - 1][nb - 1] or (1L shl (i - 1))
                    }
                }
            }
        }
        if (C == 7L && i <= 5) {
            if (i == 1) {
                _debug_println("${dpA[i][1][0]} ${dpB[i][0][1]}")
                _debug_println("${dpA[i][0][1]} ${dpB[i][1][0]}")
            }
            _debug_println(C.bit(i - 1))
            if (i == 5) {
                _debug_println(dpA[5][a][b])
                _debug_println(dpB[5][a][b])
            }
        }
    }
    if (dpA[60][a][b] < Long.MAX_VALUE && dpB[60][a][b] < Long.MAX_VALUE) {
        println("${dpA[60][a][b]} ${dpB[60][a][b]}")
    } else {
        println(-1)
    }
}