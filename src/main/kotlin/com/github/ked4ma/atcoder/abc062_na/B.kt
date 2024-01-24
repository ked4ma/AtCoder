package com.github.ked4ma.atcoder.abc062_na

import com.github.ked4ma.atcoder.utils.array.any.d2.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (h, w) = nextIntList()
    val a = (0 until h).map {
        next().toCharArray()
    }
    val ans = sized2DArray(h + 2, w + 2, '#')
    for (i in (1..h)) {
        for (j in (1..w)) {
            ans[i][j] = a[i - 1][j - 1]
        }
    }
    ans.forEach {
        println(it.joinToString(""))
    }
}
