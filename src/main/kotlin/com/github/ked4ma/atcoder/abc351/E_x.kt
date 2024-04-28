package com.github.ked4ma.atcoder.abc351

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val P = sizedArray(4) {
        mutableListOf<Long>()
    }
    repeat(N) {
        val (x, y) = nextLongList()
        if ((x + y) % 2 == 0L) {
            P[0].add(x + y)
            P[1].add(y - x)
        } else {
            P[2].add(x + y)
            P[3].add(y - x)
        }
    }
    var ans = 0L
    for (i in range(4)) {
        P[i].sort()
        val E = P[i].size
        for (j in range(E)) {
            ans += (2 * j + 1 - E) * P[i][j]
        }
    }
    println(ans / 2)
}