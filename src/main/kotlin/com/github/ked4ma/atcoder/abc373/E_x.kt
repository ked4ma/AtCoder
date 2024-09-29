package com.github.ked4ma.atcoder.abc373

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.long.bound.*
import com.github.ked4ma.atcoder.utils.list.long.cumlative.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextLongList().let { (N, M, K) -> Triple(N.toInt(), M.toInt(), K) }
    val A = nextLongList()
    val rem = K - A.sum()

    if (N == M) {
        println(sizedIntArray(N, 0).joinToString(" "))
        return
    }

    val ord = range(N).toList().sortedBy { A[it] }
    _debug_println(ord)
    val B = A.sorted()
    val sumB = B.cumulativeSum()

    val ans = sizedLongArray(N, -1)
    for (i in range(N)) {
        var l = -1L
        var r = rem + 1
        while (l + 1 < r) {
            val m = (l + r) / 2
            val rid = B.lowerBound(B[i] + m + 1)
            val lid = N - M - (if (i >= N - M) 1 else 0)
            var cnt = 0L
            if (lid < rid) cnt += (rid - lid) * (B[i] + m + 1) - (sumB[rid] - sumB[lid])
            if (i in lid until rid) {
                cnt--
            } else {
                cnt += m
            }
            if (cnt > rem) {
                r = m
            } else {
                l = m
            }
        }
        if (l == rem) {
            ans[ord[i]] = -1
        } else {
            ans[ord[i]] = r
        }
    }
    println(ans.joinToString(" "))
}
