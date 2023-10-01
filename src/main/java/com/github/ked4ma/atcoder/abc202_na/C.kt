package com.github.ked4ma.atcoder.abc202_na

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val N = nextInt()
    val A = nextIntList().toTypedArray()
    val B = nextIntList().toTypedArray()
    val C = nextIntList().toTypedArray()
    C.forEachIndexed { i, n ->
        C[i] = B[n - 1]
    }

    val groupA = A.groupingBy { it }.eachCount()
    val groupC = C.groupingBy { it }.eachCount()
    _debug_println(A.toList())
    _debug_println(C.toList())
    _debug_println(groupA)
    _debug_println(groupC)

    var count = 0L
    for (i in 1..N) {
        count += groupA.getOrDefault(i, 0).toLong() * groupC.getOrDefault(i, 0).toLong()
    }

    println(count)
}
