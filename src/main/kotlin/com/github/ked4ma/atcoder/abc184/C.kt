package com.github.ked4ma.atcoder.abc184

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.abs

fun main() {
    val (a, b) = nextLongList()
    val (c, d) = nextLongList()

    fun pos(a: Long, b: Long, c: Long, d: Long): Pair<Long, Long> {
        val x = ((a + c) - (b - d)) / 2
        return x to x - a + b
    }

    fun neg(a: Long, b: Long, c: Long, d: Long): Pair<Long, Long> {
        val x = ((c + a) - (d - b)) / 2
        return x to -x + a + b
    }

    fun dist(a: Long, b: Long, c: Long, d: Long): Long {
        return abs(a - c) + abs(b - d)
    }

    if (dist(a, b, c, d) == 0L) {
        println(0)
        return
    } else if (dist(a, b, c, d) <= 3) {
        println(1)
        return
    }

    val (ap, bp) = pos(a, b, c, d)
    val (an, bn) = neg(a, b, c, d)

    if (dist(ap, bp, c, d) == 0L || dist(an, bn, c, d) == 0L) {
        println(1)
        return
    } else if (dist(ap, bp, c, d) <= 3 || dist(an, bn, c, d) <= 3) {
        println(2)
        return
    }

    val (app, bpp) = pos(ap, bp, c, d)
    val (apn, bpn) = neg(ap, bp, c, d)
    val (anp, bnp) = pos(an, bn, c, d)
    val (ann, bnn) = neg(an, bn, c, d)

    if (dist(app, bpp, c, d) == 0L || dist(apn, bpn, c, d) == 0L || dist(anp, bnp, c, d) == 0L || dist(
            ann,
            bnn,
            c,
            d
        ) == 0L
    ) {
        println(2)
        return
    }
    println(3)
}
