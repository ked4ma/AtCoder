package com.github.ked4ma.atcoder.m_solutions2020

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val n = nextInt()
    val X = mutableListOf<Long>()
    val Y = mutableListOf<Long>()
    val P = mutableListOf<Long>()
    repeat(n) {
        val (x, y, p) = nextLongList()
        X.add(x)
        Y.add(y)
        P.add(p)
    }
    val xsel = Array(1 shl n) { Array(n) { 0L } }
    val ysel = Array(1 shl n) { Array(n) { 0L } }
    (0 until (1 shl n)).forEach { i ->
        (0 until n).forEach { j ->
            xsel[i][j] += abs(X[j])
            ysel[i][j] += abs(Y[j])
            (0 until n).forEach { k ->
                if ((i shr k) and 1 == 1) {
                    xsel[i][j] = min(xsel[i][j], abs(X[j] - X[k]))
                    ysel[i][j] = min(ysel[i][j], abs(Y[j] - Y[k]))
                }
            }
        }
    }
    (0 until (1 shl n)).forEach { i ->
        (0 until n).forEach { j ->
            xsel[i][j] *= P[j]
            ysel[i][j] *= P[j]
        }
    }

    val ans = sizedArray(n + 1, Long.MAX_VALUE)
    (0 until (1 shl n)).forEach { i ->
        val count = (0 until n).count {
            i shr it and 1 == 1
        }
        var j = i
        while (j >= 0) {
            j = j and i
            var cost = 0L
            (0 until n).forEach { k ->
                // for exec more quickly
                if ((i shr k) and 1 != 1) {
                    cost += min(xsel[j][k], ysel[i - j][k])
                } else {
                    println("haha ${xsel[j][k]} ${ysel[i - j][k]}")
                }
            }
            ans[count] = min(ans[count], cost)
            j--
        }
    }
    ans.forEach(::println)
}
