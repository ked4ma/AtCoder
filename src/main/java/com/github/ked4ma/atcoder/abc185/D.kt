package com.github.ked4ma.atcoder.abc185

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    val (n, m) = nextIntList()
    if (m == 0) {
        println(1)
        return
    }

    val a = nextIntList().sorted().let {
        it + (n + 1)
    }

    val spaces = mutableListOf<Int>()
    var i = 0
    a.forEach { j ->
        if (j - i - 1 > 0) {
            spaces.add(j - i - 1)
        }
        i = j
    }

    if (spaces.isEmpty()) {
        println(0)
        return
    }

    var ans = 0
    val k = spaces.min()!!
    spaces.forEach { s ->
        ans += s / k
        if (s % k != 0) {
            ans++
        }
    }
    println(ans)
}
