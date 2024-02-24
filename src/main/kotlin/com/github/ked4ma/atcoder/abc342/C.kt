package com.github.ked4ma.atcoder.abc342

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next().toCharArray()
    val Q = nextInt()

    val map = sizedIntArray(26, 0)
    for (c in 'a'..'z') {
        map[c - 'a'] = c - 'a'
    }

    repeat(Q) {
        val (c, d) = next().let { it[0] - 'a' to it[2] - 'a' }
        if (c == d) return@repeat
        map.forEachIndexed { i, ic ->
            if (ic == c) {
                map[i] = d
            }
        }
    }
    S.forEach { c ->
        print('a' + map[c - 'a'])
    }
}