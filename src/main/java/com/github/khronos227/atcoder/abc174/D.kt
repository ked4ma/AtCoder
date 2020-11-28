package com.github.khronos227.atcoder.abc174

import com.github.khronos227.atcoder.utils.*

fun main() {
    val n = nextInt()
    val c = next().toCharArray()
    var l = 0
    var r = n - 1
    var count = 0

    while (l < r) {
        while (l < r && c[l] == 'R') {
            l++
        }
        while (l < r && c[r] == 'W') {
            r--
        }
        if (l < r) {
            count++
            l++
            r--
        }
    }
    println(count)
}
