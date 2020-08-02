package com.github.khronos227.atcoder.m_solutions2020

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

// # Utils
// ## Input
fun next() = readLine()!!
fun nextInt() = next().toInt()
fun nextLong() = next().toLong()
fun nextDouble() = next().toDouble()
fun nextList() = next().split(" ")
fun nextIntList() = next().split(" ").map(String::toInt)
fun nextLongList() = next().split(" ").map(String::toLong)
fun nextDoubleList() = next().split(" ").map(String::toDouble)

// ## Array
inline fun <reified T> sizedArray(size: Int, default: T) = Array(size) { default }
inline fun <reified T> sized2DArray(row: Int, column: Int, default: T) = Array(row) { Array(column) { default } }

// ## mod^-1
//    [NOTE] CANNOT use this for 0, mod, 2mod, 3mod ...(return wrong value)
fun modinv(num: Long, mod: Long): Long {
    var a = num
    var b = mod
    var u = 1L
    var v = 0L
    while (b > 0) {
        val t = a.div(b)
        a -= t * b
        a = b.also { b = a } // swap a and b
        u -= t * v
        u = v.also { v = u } // swap u and v
    }
    u %= mod
    if (u < 0) u += mod
    return u
}