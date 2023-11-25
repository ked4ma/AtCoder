package com.github.ked4ma.atcoder.abc057_na

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.gcd.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*
import kotlin.math.max

fun main() {
    val (n, a, b) = nextIntList()
    val vList = nextLongList()

    val dp = sized2DArray(n + 1, n + 1, 0L to 0L)
    for (i in (0..n)) {
        dp[i][0] = 0L to 1L
    }

    for (i in (0 until n)) {
        val v = vList[i]
        for (j in (0..i)) {
            val value = max(
                dp[i][j + 1].first,
                dp[i][j].first + v
            )
            val count = (if (dp[i][j + 1].first == value) dp[i][j + 1].second else 0) +
                    (if (dp[i][j].first + v == value) dp[i][j].second else 0)
            dp[i + 1][j + 1] = value to count
        }
    }
//    dp.forEach {
//        println(it.joinToString(","))
//    }

    data class Fraction(val num: Long, val denom: Long) {
        val value: Double by lazy { num.toDouble() / denom }
    }

    dp.last().let { result ->
        val count = (a..b).map {
            val d = gcd(result[it].first, it.toLong())
            Fraction(result[it].first / d, it.toLong() / d) to result[it].second
        }.groupBy(Pair<Fraction, Long>::first, Pair<Fraction, Long>::second).mapKeys {
            it.key.value
        }.mapValues { (_, v) ->
            v.sum()
        }
        val avg = count.keys.max()
        println("%.6f".format(avg))
        println(count[avg])
    }
}
