package com.github.ked4ma.atcoder.abc367

import com.github.ked4ma.atcoder.utils.input.default.*
import java.util.StringJoiner

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val R = nextIntList()
    var list = listOf(0)
    for (i in N - 1 downTo 0) {
        list = buildList {
            for (r in 1..R[i]) {
                for (n in list) {
                    add(n * 10 + r)
                }
            }
        }
    }
    for (n in list) {
        val res = n.toString().map { it - '0' }.toList().asReversed()
        if (res.sum() % K == 0) {
            println(res.joinToString(" "))
        }
    }
}
