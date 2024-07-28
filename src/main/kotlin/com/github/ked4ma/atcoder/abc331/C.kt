package com.github.ked4ma.atcoder.abc331

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.cumlative.*
import com.github.ked4ma.atcoder.utils.list.long.cumlative.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    val A = nextLongList()
    val A2 = A.sortedDescending()
    val cumA = A2.cumulativeSum()
    _debug_println(A)
    _debug_println(cumA)
    _debug_println(A.size)
    _debug_println(cumA.size)
    var prev = Long.MAX_VALUE
    val cumMap = mutableMapOf<Long, Long>()
    A2.forEachIndexed { index, l ->
        if (prev != l) {
            prev = l
            cumMap[l] = cumA[index]
        }
    }
    val sj = StringJoiner(" ")
    A.forEach {a ->
        sj.add(cumMap.getValue(a).toString())
    }
    println(sj)
}