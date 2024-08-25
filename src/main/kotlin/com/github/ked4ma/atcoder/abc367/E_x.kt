package com.github.ked4ma.atcoder.abc367

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextLongList().let { (N, K) -> N.toInt() to K }
    val X = nextIntList().map { it - 1 }
    val A = nextLongList()

    val k = X.toIntArray().pow(K)
    _debug_println(k.joinToString(" "))

    val sb = StringJoiner(" ")
    for (i in range(N)) {
        sb.add(A[k[i]].toString())
    }
    println(sb)
}

private fun IntArray.pow(k: Long): IntArray {
    val w = this.size
    val res = IntArray(w) { it }
    var i = k
    val m = this.copyOf()
    while (i > 0) {
        if (i and 1L == 1L) {
            for (j in range(w)) {
                res[j] = m[res[j]]
            }
        }
        val tmp = m.copyOf()
        for (j in range(w)) {
            m[j] = tmp[m[j]]
        }
        i = i shr 1
    }
    return res
}
