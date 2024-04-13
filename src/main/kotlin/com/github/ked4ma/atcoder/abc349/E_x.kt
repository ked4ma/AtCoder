package com.github.ked4ma.atcoder.abc349

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val A = times(3) {
        nextLongList()
    }

    val state = sizedIntArray(9, -1)
    fun check(colors: List<Int>) = colors.toSet().size == 1 && colors.first() != -1
    fun rec(turn: Int = 0): Int {
        // row
        for (i in range(3)) {
            if (check(times(3) { j -> state[3 * i + j] })) {
                return state[3 * i]
            }
        }
        // col
        for (j in range(3)) {
            if (check(times(3) { i -> state[3 * i + j] })) {
                return state[j]
            }
        }
        // diag
        if (check(times(3) { i -> state[3 * i + i] })) {
            return state[0]
        }
        if (check(times(3) { i -> state[6 - 2 * i] })) {
            return state[2]
        }
        if (-1 !in state) {
            val score = sizedLongArray(2, 0)
            for (i in range(3)) {
                for (j in range(3)) {
                    score[state[3 * i + j]] += A[i][j]
                }
            }
            return if (score[0] > score[1]) 0 else 1
        }

        for (k in range(9)) {
            if (state[k] == -1) {
                state[k] = turn
                if (rec(turn xor 1) == turn) {
                    state[k] = -1
                    return turn
                }
                state[k] = -1
            }
        }
        return turn xor 1
    }
    println(arrayOf("Takahashi", "Aoki")[rec(0)])
}
