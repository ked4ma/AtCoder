package com.github.khronos227.atcoder.abc062_na

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