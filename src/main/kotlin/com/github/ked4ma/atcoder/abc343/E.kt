package com.github.ked4ma.atcoder.abc343

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    // (7 * 7 * 7) * 3 = 1029
    // 840 + (84 * 2) + (7 * 3)
    val (V1, V2, V3) = nextIntList()
    val T = (7 * 7 * 7) * 3
    if (V1 + V2 * 2 + V3 * 3 != T) {
        println("No")
        return
    }
    val (a1, b1, c1) = listOf(0, 0, 0)
    fun check3(a2: Int, b2: Int, c2: Int, a3: Int, b3: Int, c3: Int): Int {
        val x = (minOf(a1 + 7, a2 + 7, a3 + 7) - maxOf(a1, a2, a3)).coerceAtLeast(0)
        val y = (minOf(b1 + 7, b2 + 7, b3 + 7) - maxOf(b1, b2, b3)).coerceAtLeast(0)
        val z = (minOf(c1 + 7, c2 + 7, c3 + 7) - maxOf(c1, c2, c3)).coerceAtLeast(0)
        return x * y * z
    }

    fun check2(a2: Int, b2: Int, c2: Int, a3: Int, b3: Int, c3: Int): Int {
        fun size(x1: Int, y1: Int, z1: Int, x2: Int, y2: Int, z2: Int): Int {
            val x = (min(x1 + 7, x2 + 7) - max(x1, x2)).coerceAtLeast(0)
            val y = (min(y1 + 7, y2 + 7) - max(y1, y2)).coerceAtLeast(0)
            val z = (min(z1 + 7, z2 + 7) - max(z1, z2)).coerceAtLeast(0)
            return x * y * z
        }
        return size(a1, b1, c1, a2, b2, c2) + size(a2, b2, c2, a3, b3, c3) + size(a1, b1, c1, a3, b3, c3)
    }

    fun check(a2: Int, b2: Int, c2: Int, a3: Int, b3: Int, c3: Int): Boolean {
        val size3 = check3(a2, b2, c2, a3, b3, c3)
        val size2 = check2(a2, b2, c2, a3, b3, c3) - size3 * 3
        val size1 = T - size2 * 2 - size3 * 3
        return size1 == V1 && size2 == V2 && size3 == V3
    }

    for (a2 in 0..8) {
        for (b2 in 0..8) {
            for (c2 in 0..8) {
                for (a3 in -7..8) {
                    for (b3 in -7..8) {
                        for (c3 in -7..8) {
                            if (check(a2, b2, c2, a3, b3, c3)) {
                                println("Yes")
                                println("$a1 $b1 $c1 $a2 $b2 $c2 $a3 $b3 $c3")
                                return
                            }
                        }
                    }
                }
            }
        }
    }
    println("No")
}