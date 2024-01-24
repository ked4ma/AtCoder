package com.github.ked4ma.atcoder.m_solutions2020

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (N, K) = nextIntList()
    val A = nextIntList()
    (K until N).forEach {
        println(if (A[it - K] >= A[it]) "No" else "Yes")
    }
}
