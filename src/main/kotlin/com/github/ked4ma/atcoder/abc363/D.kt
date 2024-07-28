package com.github.ked4ma.atcoder.abc363

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.cumlative.*
import com.github.ked4ma.atcoder.utils.list.long.cumlative.*
import com.github.ked4ma.atcoder.utils.math.long.pow.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    if (N <= 10) {
        println(N - 1)
        return
    }

    val cnt = mutableListOf(10L)
    val cum = cnt.cumulativeSum().toMutableList()
    var i = 2
    while (cum.last() < N) {
        cnt.add(9 * 10L.pow((i - 1) / 2))
        cum.add(cum.last() + cnt.last())
        i++
    }
    _debug_println(cnt)
    _debug_println(cum)
    _debug_println(cnt.size)
    _debug_println(cum.size)
    if (cnt.size % 2 == 0) {
        val s = ((N - cum[cum.lastIndex - 1]) + 10L.pow((cnt.size / 2) - 1) - 1).toString()
        _debug_println(s)
        println("$s${s.reversed()}")
    } else {
        val l = cnt.size / 2
        val s = ((N - cum[cum.lastIndex - 1]) + 10L.pow(l) - 1).toString()
        _debug_println(s)
        println("$s${s.reversed().slice(1 until s.length)}")
    }
}
