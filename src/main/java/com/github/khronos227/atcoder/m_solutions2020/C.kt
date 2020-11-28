package com.github.khronos227.atcoder.m_solutions2020

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (N, K) = nextIntList()
    val A = nextIntList()
    (K until N).forEach {
        println(if (A[it - K] >= A[it]) "No" else "Yes")
    }
}
