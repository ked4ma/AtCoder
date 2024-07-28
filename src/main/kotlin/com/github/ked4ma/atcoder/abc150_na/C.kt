package com.github.ked4ma.atcoder.abc150_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.general.permutation.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    val P = nextLongList()
    val Q = nextLongList()
    val list = (1L..N).toList().permutations(N.toInt()).map {
        it.joinToString("").toLong()
    }.sorted()
    val a = list.indexOf(P.joinToString("").toLong())
    val b = list.indexOf(Q.joinToString("").toLong())
    println(abs(a - b))
}