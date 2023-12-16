package com.github.ked4ma.atcoder.abc202_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.combimation.*

fun main() {
    var (A, B, K) = nextLongList()
        .let { (A, B, K) -> Triple(A.toInt(), B.toInt(), K) }
    val sb = StringBuilder()
    while (A > 0 && B > 0) {
        val k = combination((A - 1 + B).toLong(), B.toLong())
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
