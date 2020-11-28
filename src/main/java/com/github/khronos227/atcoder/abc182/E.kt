package com.github.khronos227.atcoder.abc182

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (h, w, n, m) = nextIntList()
    val mat = sized2DArray(h, w, 0)

    // light
    repeat(n) {
        val (a, b) = nextIntList()
        mat[a - 1][b - 1] = 1
    }

    // block
    repeat(m) {
        val (c, d) = nextIntList()
        mat[c - 1][d - 1] = -1
    }

    var count = 0
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (mat[i][j] == 1) {
                count++
                continue
            }
            if (mat[i][j] == -1) continue

            var k = j
            var left = false
            while (k > 0) {
                k--
                if (mat[i][k] == 0) continue
                left = mat[i][k] == 1
                break
            }

            k = j
            var right = false
            while (k < w - 1) {
                k++
                if (mat[i][k] == 0) continue
                right = mat[i][k] == 1
                break
            }

            k = i
            var up = false
            while (k > 0) {
                k--
                if (mat[k][j] == 0) continue
                up = mat[k][j] == 1
                break
            }

            k = i
            var down = false
            while (k < h - 1) {
                k++
                if (mat[k][j] == 0) continue
                down = mat[k][j] == 1
                break
            }
            if (left || right || up || down) count++
        }
    }
    println(count)

//    val lights = (0 until n).map {
//        val (a, b) = nextIntList()
//        a - 1 to b - 1
//    }.toSet()
//    val lightRows = lights.groupBy { it.first }
//    val lightCols = lights.groupBy { it.second }
//    val blocks = (0 until m).map {
//        val (c, d) = nextIntList()
//        c - 1 to d - 1
//    }.toSet()
//    val blockRows = blocks.groupBy { it.first }
//    val blockCols = blocks.groupBy { it.second }
//
//    var count = 0
//    for (i in 0 until h) {
//        for (j in 0 until w) {
//            val point = i to j
//            if (point in lights) {
//                count++
//                continue
//            }
//            if (point in blocks) continue
//            val nearestRowLight = lightRows[i]?.let {
//                var nearest = it.first()
//                var diff = abs(nearest.second - j)
//            }
//        }
//    }
}
