package com.github.ked4ma.atcoder.abc106_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val s = next()
    val k = nextLong()

    val firstOnes = s.takeWhile { it == '1' }
    if (firstOnes.length.toLong() >= k) {
        println('1')
        return
    }

    println(s.firstOrNull() { it > '1' })
}
