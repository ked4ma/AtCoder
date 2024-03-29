package com.github.ked4ma.atcoder.m_solutions2020

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val n = nextInt()
    val a = nextIntList()
    var stock = 0L
    var account = 1000L
    repeat(n - 1) {
        when {
            a[it] < a[it + 1] -> {
                stock += account / a[it]
                account %= a[it]
            }

            a[it] > a[it + 1] -> {
                account += stock * a[it]
                stock = 0
            }

            else -> Unit
        }
    }
    account += stock * a.last()
    println(account)
}
