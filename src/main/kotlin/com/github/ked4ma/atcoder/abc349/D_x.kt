package com.github.ked4ma.atcoder.abc349

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var (L, R) = nextLongList()
    val ans = mutableListOf<Pair<Long, Long>>()
    while (L != R) {
        var i = 1L
        while (L % (2 * i) == 0L && L + (2 * i) <= R) {
            i *= 2
        }
        ans.add(L to L + i)
        L += i
    }
    println(ans.size)
    ans.forEach { (l, r) ->
        println("$l $r")
    }
}
