package com.github.ked4ma.atcoder.abc377

import com.github.ked4ma.atcoder.utils.array.boolean.d1.*
import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.long.pow.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextLongList().let { (N, K) -> N.toInt() to K }
    val P = nextIntList().map { it - 1 }.toIntArray()
    _debug_println(P.map { it + 1 }.joinToString(" "))

    val ans = sizedIntArray(N, 0)
    val used = sizedBooleanArray(N, false)
    for (i in range(N)) {
        if (used[i]) continue
        val cycle = mutableListOf<Int>()
        run {
            var j = i
            while (!used[j]) {
                used[j] = true
                cycle.add(j)
                j = P[j]
            }
        }
        _debug_println(cycle.map { it + 1 })
        val cycleLength = cycle.size
        val shift = 2L.powMod(K, cycleLength.toLong()).toInt()
        for (j in range(cycleLength)) {
            ans[cycle[j]] = cycle[(j + shift) % cycleLength]
        }
    }
    println(ans.map { it + 1 }.joinToString(" "))
}