package com.github.ked4ma.atcoder.abc263_na

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    val (N, M) = nextIntList()
    var list = (1..M).map { listOf(it) }
    repeat(N - 1) {
        list = buildList {
            list.forEach { elems ->
                for (i in elems.last() + 1..M) {
                    add(elems + i)
                }
            }
        }
    }
    list.forEach { println(it.joinToString(separator = " ")) }
}
