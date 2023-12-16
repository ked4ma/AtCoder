package com.github.ked4ma.atcoder.m_solutions2020

import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    var (A, B, C) = nextIntList()
    val K = nextInt()
    var count = 0
    while (A >= B) {
        count++
        B *= 2
    }
    while (B >= C) {
        count++
        C *= 2
    }
    println(if (K >= count) "Yes" else "No")
}
