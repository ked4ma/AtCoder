package com.github.ked4ma.atcoder.abc366

import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, D) = nextIntList().let { (N, D) -> N to D.toLong() }
    val X = mutableListOf<Long>()
    val Y = mutableListOf<Long>()
    repeat(N) {
        val (x, y) = nextLongList()
        X.add(x)
        Y.add(y)
    }
    val M = 2_000_000

    fun calc(vals: List<Long>): LongArray {
        val sum = sizedLongArray(2 * M + 1, 0)
        var i = 0
        sum[0] = vals.sum() + N * M.toLong()
        for (z in -M + 1..M) {
            while (i < N && vals[i] < z) {
                i++
            }
            sum[z + M] = sum[z - 1 + M] + i - (N - i)
        }
        return sum
    }

    val xsum = calc(X.sorted()).sorted()
    val ysum = calc(Y.sorted()).sorted()

    var ans = 0L
    var j = 0
    for (i in 2 * M downTo 0) {
        while (j < 2 * M + 1 && xsum[i] + ysum[j] <= D) {
            j++
        }
        ans += j
    }
    println(ans)
}
