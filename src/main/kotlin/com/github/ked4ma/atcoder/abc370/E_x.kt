package com.github.ked4ma.atcoder.abc370

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.number.mod.long.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextLongList().let { (N, K) -> N.toInt() to K }
    val A = nextLongList()

    val MOD = 998_244_353L
    val M = mutableMapOf<Long, ModLong>()
    M[0] = ModLong(1, MOD)
    var all = ModLong(1, MOD)
    var acc = 0L

    repeat(N) { i ->
        acc += A[i]
        val ban = acc - K
        val cur = all - M.getOrDefault(ban, ModLong(0, MOD))
        M[acc] = M.getOrDefault(acc, ModLong(0, MOD)) + cur
        all += cur
        if (i + 1 == N) {
            println(cur.toLong())
        }
    }
}
