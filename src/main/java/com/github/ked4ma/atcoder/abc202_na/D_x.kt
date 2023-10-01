package com.github.ked4ma.atcoder.abc202_na

import com.github.ked4ma.atcoder.utils.combination.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    var (A, B, K) = nextLongList()
        .let { (A, B, K) -> Triple(A.toInt(), B.toInt(), K) }
    val sb = StringBuilder()
    while (A > 0 && B > 0) {
        val k = combination(A - 1 + B, B)
        if (K <= k) {
            sb.append('a')
            A -= 1
        } else {
            sb.append('b')
            K -= k
            B -= 1
        }
    }
    if (A > 0) {
        sb.append("a".repeat(A))
    }
    if (B > 0) {
        sb.append("b".repeat(B))
    }
    println(sb.toString())
}
