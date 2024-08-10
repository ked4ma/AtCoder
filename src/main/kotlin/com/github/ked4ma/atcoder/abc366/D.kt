package com.github.ked4ma.atcoder.abc366

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.cumlative.d2sum.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = times(N) {
        CumulativeSum2D(
            times(N) {
                nextLongList().toLongArray()
            }.toTypedArray()
        )
    }
    val Q = nextInt()
    repeat(Q) {
        // Lx Rx Ly Ry Lz Rz
        val input = nextIntList().map { it - 1 }
        _debug_println(input)
        var ans = 0L
        for (x in input[0]..input[1]) {
            _debug_println(A[x].getSumOf(input[4], input[2], input[5], input[3]))
            ans += A[x].getSumOf(input[4], input[2], input[5], input[3])
        }
        println(ans)
    }
}
