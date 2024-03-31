package com.github.ked4ma.atcoder.abc347

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.boolean.d1.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.cumlative.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val X = nextIntList()
    val A = sizedLongArray(N, 0)
    val sizeS = sizedLongArray(Q, 0)
    val periods = sizedArray(N) { mutableListOf<Int>() }
    run {
        var sum = 0L
        val tmp = sizedBooleanArray(N + 1, false)
        X.forEachIndexed { i, x ->
            tmp[x] = !tmp[x]
            sum += if (tmp[x]) 1 else -1
            sizeS[i] += sum
            periods[x - 1].add(i)
        }
    }
    val cum = sizeS.toList().cumulativeSum()

    for (i in range(N)) {
        val period = periods[i]
        var sum = 0L
        for (j in 0 until period.size step 2) {
            val start = period[j]
            val end = period.getOrNull(j + 1) ?: Q
            sum += cum[end] - cum[start]
        }
        A[i] += sum
    }
    println(A.joinToString(" "))
}