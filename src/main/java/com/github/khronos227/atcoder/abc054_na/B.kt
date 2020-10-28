package com.github.khronos227.atcoder.abc054_na

fun main() {
    val (n, m) = nextIntList()
    val a = (0 until n).map {
        next().toCharArray()
    }
    val b = (0 until m).map {
        next().toCharArray()
    }
    for (i in (0..(n - m))) {
        j@ for (j in (0..(n - m))) {
            for (y in (0 until m)) {
                for (x in (0 until m)) {
                    if (a[i + y][j + x] != b[y][x]) continue@j
                }
            }
            println("Yes")
            return
        }
    }
    println("No")
}
