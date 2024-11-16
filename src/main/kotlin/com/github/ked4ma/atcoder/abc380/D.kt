package com.github.ked4ma.atcoder.abc380

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val Q = nextInt()
    val K = nextLongList()

    var len = S.size.toLong()
    while (len <= Long.MAX_VALUE / 2) {
        len *= 2
    }

    fun f(k: Long, l: Long): Char {
        if (k < S.size) return S[k.toInt()]
        if (k < l / 2) {
            return f(k, l / 2)
        } else {
            val res = f(k - l / 2, l / 2)
            return if (res.isLowerCase()) res.uppercaseChar() else res.lowercaseChar()
        }
    }

    val ans = mutableListOf<Char>()
    for (k in K) {
        ans.add(f(k - 1, len))
    }
    println(ans.joinToString(" "))
}
