package com.github.khronos227.atcoder.abc178

import com.github.khronos227.atcoder.utils.*

private val MOD = 1_000_000_007L

fun main() {
    fun powmod(base: Int, n: Int): Long {
        var res = base.toLong()
        repeat(n - 1) {
            res *= base
            if (res >= MOD) {
                res %= MOD
            }
        }
        return res
    }

    val n = nextInt()
    println((MOD + powmod(10, n) - powmod(9, n).times(2).rem(MOD) + powmod(8, n)).rem(MOD))
}
