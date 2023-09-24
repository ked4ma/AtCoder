package com.github.ked4ma.atcoder.abc264_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (H1, W1) = nextIntList()
    val A = (0 until H1).map {
        nextIntList()
    }
    val (H2, W2) = nextIntList()
    val B = (0 until H2).map {
        nextIntList()
    }

    fun check(rows: Int, cols: Int): Boolean {
        _debug_println("${(0 until H1).filter { rows and (1 shl it) > 0 }} ${(0 until W1).filter { cols and (1 shl it) > 0 }}")
        (0 until H1).filter { rows and (1 shl it) > 0 }.forEachIndexed { r, i ->
            (0 until W1).filter { cols and (1 shl it) > 0 }.forEachIndexed { c, j ->
                if (A[i][j] != B[r][c]) {
                    return false
                }
            }
        }
        return true
    }
    (1 until (1 shl H1)).filter { it.countOneBits() == H2 }.forEach { rows ->
        (1 until (1 shl W1)).filter { it.countOneBits() == W2 }.forEach { cols ->
            if (check(rows, cols)) {
                println("Yes")
                return
            }
        }
    }
    println("No")
}
