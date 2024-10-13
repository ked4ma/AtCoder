package com.github.ked4ma.atcoder.abc375

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = times(N) {
        nextCharArray()
    }.toTypedArray()

    val ans = sizedArray(N) { i -> S[i].copyOf() }
    fun mov1(x: Int, y: Int) {
        ans[y - 1][(N + 1 - x) - 1] = S[x - 1][y - 1]
    }

    fun mov2(x: Int, y: Int) {
        ans[(N + 1 - x) - 1][(N + 1 - y) - 1] = S[x - 1][y - 1]
    }

    fun mov3(x: Int, y: Int) {
        ans[(N + 1 - y) - 1][(N + 1 - (N + 1 - x)) - 1] = S[x - 1][y - 1]
    }

    for (i in 1..N / 2) {
        val mov = when (i % 4) {
            1 -> ::mov1
            2 -> ::mov2
            3 -> ::mov3
            else -> continue
        }

        val j = N + 1 - i
        // top
        run {
            val x = i
            for (y in i until j) {
                mov(x, y)
            }
        }
        // right
        run {
            val y = j
            for (x in i until j) {
                mov(x, y)
            }
        }
        // bottom
        run {
            val x = j
            for (y in j downTo i + 1) {
                mov(x, y)
            }
        }
        // left
        run {
            val y = i
            for (x in j downTo i + 1) {
                mov(x, y)
            }
        }
    }
    println(ans.joinToString("\n") { it.joinToString("") })
}
