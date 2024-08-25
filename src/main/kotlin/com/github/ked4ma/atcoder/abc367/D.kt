package com.github.ked4ma.atcoder.abc367

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.long.cumlative.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextLongList()
    val sum = A.sum()
    val cum = (A + A).cumulativeSum()
    _debug_println(cum)
    val arr = sizedIntArray(M, 0)
    var res = 0L
    for (i in range(N)) {
        val j = (cum[i] % M).toInt()
        arr[j]++
    }
    for (i in range(N)) {
        val j = (cum[i] % M).toInt()
        arr[j]--
        res += arr[j]
        arr[((j + sum) % M).toInt()]++
    }
    println(res)
}
