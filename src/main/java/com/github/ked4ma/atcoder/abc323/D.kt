package com.github.ked4ma.atcoder.abc323

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    _debug_println(N)

    val slimeMap = mutableMapOf<Long, Long>()
    repeat(N) {
        nextLongList().let { (S, C) ->
            var s = S
            var c = C
            while (s % 2 == 0L) {
                s /= 2
                c *= 2
            }
            slimeMap[s] = slimeMap.getOrDefault(s, 0L) + c
        }
    }
    var count = 0L
    slimeMap.values.forEach {
        var c = it
        while (c > 0) {
            count += (c % 2)
            c /= 2
        }
    }
    println(count)
}