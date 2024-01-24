package com.github.ked4ma.atcoder.abc188

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val N = nextInt()
    var n = 1
    repeat(N) {
        n *= 2
    }
    val A = nextLongList()
    var leftIndex = 0
    var leftValue = A[leftIndex]
    for (i in 1 until n / 2) {
        if (leftValue < A[i]) {
            leftIndex = i
            leftValue = A[i]
        }
    }
    var rightIndex = n / 2
    var rightValue = A[rightIndex]
    for (j in n / 2 + 1 until n) {
        if (rightValue < A[j]) {
            rightIndex = j
            rightValue = A[j]
        }
    }
    println(if (leftValue > rightValue) rightIndex + 1 else leftIndex + 1)
}
