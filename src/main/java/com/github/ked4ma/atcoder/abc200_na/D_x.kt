package com.github.ked4ma.atcoder.abc200_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*
import kotlin.math.min

// use Pigeonhole principle
fun main() {
    val N = nextInt()
    val A = nextIntList()

    val memo = Array(200) {
        emptyList<Int>()
    }

    val cnt = min(N, 8)
    for (i in 1 until (1 shl cnt)) {
        var sig = 0
        val s = mutableListOf<Int>()
        for (j in 0 until cnt) {
            if (i and (1 shl j) > 0) {
                s.add(j + 1)
                sig += A[j]
                sig %= 200
            }
        }
        if (memo[sig].isNotEmpty()) {
            println("Yes")
            println("${memo[sig].size} ${memo[sig].joinToString(separator = " ")}")
            println("${s.size} ${s.joinToString(separator = " ")}")
            return
        }
        memo[sig] = s
    }
    println("No")
}
