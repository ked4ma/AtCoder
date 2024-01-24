package com.github.ked4ma.atcoder.abc337

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val inv = sizedIntArray(N + 1, 0)
    var F = -1
    for (i in 1..N) {
        if (A[i - 1] == -1) {
            F = i
        } else {
            inv[A[i - 1]] = i
        }
    }
    _debug_println(F)
    _debug_println(inv.joinToString(","))
    val sj = StringJoiner(" ")
    sj.add(F.toString())
    for (i in 0 until N - 1) {
        F = inv[F]
        sj.add(F.toString())
    }
    println(sj.toString())
}
//fun main() {
//    val N = nextLong()
//    val A = nextLongList().mapIndexed { i, l ->
//        l to i.toLong() + 1
//    }.toMap().toMutableMap()
//    var i = -1L
//    val sj = StringJoiner(" ")
//    while (A.isNotEmpty()) {
//        i = A.remove(i)!!
//        sj.add(i.toString())
//    }
//    println(sj.toString())
//}
