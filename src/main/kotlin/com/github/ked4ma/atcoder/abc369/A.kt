package com.github.ked4ma.atcoder.abc369

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (A, B) = nextIntList()
    var ans = mutableSetOf<Int>()
    // xAB, ABx
    run {
        val diff = B - A
        ans.add(A - diff)
        ans.add(B + diff)
    }
    _debug_println(ans)
    // xBA, BAx
    run {
        val diff = A - B
        ans.add(B - diff)
        ans.add(A + diff)
    }
    _debug_println(ans)
    // AxB, BxA
    run {
        if ((B - A) % 2 == 0) {
            val diff = (B - A) / 2
            ans.add(A + diff)
            ans.add(B - diff)
        }
    }
    _debug_println(ans)
    println(ans.size)
}
