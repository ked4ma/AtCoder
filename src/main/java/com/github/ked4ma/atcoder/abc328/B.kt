package com.github.ked4ma.atcoder.abc328

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val D = nextIntList()
    D.mapIndexed { index, d ->
        val monthList = (index + 1).toString().toCharArray().distinct()
        if (monthList.size != 1) return@mapIndexed 0
        val m = monthList.first().toString().toInt()
        var count = 0
        var day = m
        while (day <= d) {
            _debug_println(day)
            count++
            day = day * 10 + m
        }
        return@mapIndexed count
    }.sum().let {
        println(it)
    }
}