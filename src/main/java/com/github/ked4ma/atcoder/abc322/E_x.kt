package com.github.ked4ma.atcoder.abc322

import com.github.ked4ma.atcoder.utils.array.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.loop.*
import kotlin.math.min

fun main() {
    val (N, K, P) = nextIntList()
    val C = mutableListOf<Int>()
    val A = times(N) {
        val list = nextIntList()
        C.add(list.first())
        list.subList(1, K + 1)
    }
    var s = 1
    repeat(K) {
        s *= (P + 1)
    }
    val dp = sized2DArray(N + 1, s, Long.MAX_VALUE / 2)
    dp[0][0] = 0

    fun baseToArr(base: Int): Array<Int> {
        var n = base
        return buildList {
            repeat(K) {
                add(n % (P + 1))
                n /= (P + 1)
            }
        }.toTypedArray()
    }

    fun arrToBase(arr: Array<Int>): Int {
        var n = 0
        (K - 1 downTo 0).forEach {
            n *= (P + 1)
            n += arr[it]
        }
        return n
    }

    _debug_println(dp[N][s - 1])

    repeat(N) {
        val i = it + 1
        repeat(s) { j ->
            dp[i][j] = min(dp[i][j], dp[i - 1][j])
            // int (base P + 1) -> arr
            val arr = baseToArr(j)
            repeat(K) {
                arr[it] = min(P, arr[it] + A[i - 1][it])
            }
            val num = arrToBase(arr)
            dp[i][num] = min(dp[i][num], dp[i - 1][j] + C[i - 1])
        }
    }

    val ans = dp[N][s - 1]
    println(if (ans == Long.MAX_VALUE / 2) -1 else ans)
}
