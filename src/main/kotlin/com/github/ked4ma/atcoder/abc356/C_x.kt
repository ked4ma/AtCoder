package com.github.ked4ma.atcoder.abc356

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextIntList()
    val ALL = (1 shl N) - 1

    data class Data(val c: Int, val keys: Int, val open: Boolean)

    val data = times(M) {
        val s = nextList()
        val c = s.first().toInt()
        var keys = 0
        for (k in s.subList(1, 1 + c)) {
            keys += 1 shl (k.toInt() - 1)
        }
        val open = s.last().let { it == "o" }
        Data(c, keys, open)
    }

    var ans = 0
    for (i in range(1 shl N)) {
        var ok = true
        for ((c, keys, open) in data) {
            val bit = (i and keys).countOneBits()
            if (bit >= K && !open) {
                ok = false
                break
            }
            if (bit < K && open) {
                ok = false
                break
            }
        }
        if (ok) ans++
    }
    println(ans)
}
