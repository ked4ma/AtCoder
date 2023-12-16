package com.github.ked4ma.atcoder.abc053_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    var n = nextInt()
    val a = nextIntList().groupingBy { it }.eachCount().filterValues { it > 1 }.toMutableMap()
    val keys = a.keys.toList()

    for (i in keys.indices) {
        var v = a.getValue(keys[i])
        if (v >= 4) {
            val removable = ((v - 2) / 2) * 2
            n -= removable
            v -= removable
        }
        if (v == 1) continue
        if (v == 3) {
            n -= 2
            continue
        }
        // v = 2
        if (i < keys.lastIndex) {
            a[keys[i + 1]] = a.getValue(keys[i + 1]) - 1
        }
        n -= 2
    }
    println(n)
}
