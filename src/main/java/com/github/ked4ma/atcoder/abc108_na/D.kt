package com.github.ked4ma.atcoder.abc108_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val L = nextLong()
    var r = 1
    var n = 2
    while (n <= L) {
        r++
        n *= 2
    }
    r--
    n /= 2

    val edges = mutableListOf<String>()

    var l = L
    var x = n / 2
    for (t in r downTo 1) {
        if (l - x >= n) {
            edges.add("$t ${r + 1} ${l - x}")
            l -= x
        }
        edges.add("$t ${t + 1} $x")
        edges.add("$t ${t + 1} 0")
        x /= 2
    }

    println("${r + 1} ${edges.size}")
    println(edges.joinToString("\n"))
}
