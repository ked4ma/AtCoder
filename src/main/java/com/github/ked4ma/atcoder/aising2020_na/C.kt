package com.github.ked4ma.atcoder.aising2020_na

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.ceil
import kotlin.math.sqrt

fun main() {
    val N = nextInt()
    val MAX = ceil(sqrt(N.toDouble().div(3))).toInt()
    (1..N).forEach { n ->
        var count = 0
        (1..MAX).forEach { x ->
            (x..MAX).forEach TEST@{ y ->
                (y..N.minus(x).minus(y)).forEach { z ->
                    val value = f(x, y, z)
                    when {
                        value == n -> {
                            count += when (setOf(x, y, z).size) {
                                1 -> 1
                                2 -> 3
                                else -> 6
                            }
                        }
                        value > n -> return@TEST
                    }
                }
            }
        }
        println(count)
    }
}

private fun f(x: Int, y: Int, z: Int): Int {
    return x.times(x).plus(y.times(y)).plus(z.times(z)).plus(x.times(y)).plus(y.times(z)).plus(z.times(x))
}
