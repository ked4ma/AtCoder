package com.github.ked4ma.atcoder.abc194_na

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.max

// https://ikatakos.com/pot/programming_algorithm/contest_history/atcoder/2021/0306_abc194#e_-_mex_min
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()

    val prev = sizedArray(N, 0)
    val maxDist = sizedArray(N, 0)
    A.forEachIndexed { i, n ->
        val index = i + 1
        val p = prev[n]
        maxDist[n] = max(maxDist[n], index - p - 1)
        prev[n] = index
    }
    _debug_println(A)
    _debug_println(maxDist.toList())

    for (n in (0..N)) {
        val p = prev[n]
        val dist = max(maxDist[n], N - p)
        if (dist >= M) {
            print(n)
            break
        }
    }
}
