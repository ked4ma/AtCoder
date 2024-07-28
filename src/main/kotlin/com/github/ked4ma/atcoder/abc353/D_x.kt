package com.github.ked4ma.atcoder.abc353

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.cumlative.*
import com.github.ked4ma.atcoder.utils.list.long.cumlative.*
import com.github.ked4ma.atcoder.utils.math.long.pow.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = 998_244_353L
    val N = nextInt()
    val A = nextLongList()//.sorted()
    val lenA = A.map { it.toString().length }
    var pad = 0
    val leftCum = A.cumulativeSum()

    // NOTE: this problem is not MONOID. so must not be sorted.
    //    var ans = 0L
    //    for (j in 1 until N) {
    //        val len = lenA[j]
    //        if (pad < len) {
    //            pad = len
    //        }
    //        ans += (j * A[j]) % MOD + leftCum[j].timesMod(10L.pow(len) % MOD, MOD)
    //        _debug_println(ans)
    //    }
    //    println(ans %  MOD)

    var ans = 0L
    var preSum = 0L
    for (i in range(N)) {
        ans += A[i] * i + preSum * (10L.pow(lenA[i]) % MOD)
        preSum += A[i]
    }
    println(ans % MOD)
}
