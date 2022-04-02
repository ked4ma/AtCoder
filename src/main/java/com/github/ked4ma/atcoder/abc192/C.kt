package com.github.ked4ma.atcoder.abc192

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (nStr, K) = nextList().let { (N, K) -> N to K.toInt() }
    var N = nStr.toLong()
    var (nMax, nMin) = nStr.toCharArray().map { it - '0' }.let {
        it.sortedDescending().joinToString("").toLong() to
                it.sorted().joinToString("").toLong()
    }
    _debug_println(N)
    _debug_println(K)

    repeat(K) {
        if (N == nMax - nMin) {
            println(N)
            return
        }

        N = nMax - nMin

        N.toString().toCharArray().map { it - '0' }.let {
            nMax = it.sortedDescending().joinToString("").toLong()
            nMin = it.sorted().joinToString("").toLong()
        }
    }
    println(N)
}
