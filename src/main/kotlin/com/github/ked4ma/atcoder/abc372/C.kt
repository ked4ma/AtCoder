package com.github.ked4ma.atcoder.abc372

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val S = nextCharArray()
    var n = 0
    run {
        var i = 0
        while (i < N - 2) {
            if (S[i] == 'A' && S[i + 1] == 'B' && S[i + 2] == 'C') {
                n++
                i += 3
            } else {
                i++
            }
        }
    }
    _debug_println(n)
    repeat(Q) {
        val (x, c) = nextList().let { (x, c) -> x.toInt() - 1 to c[0] }
        when (S[x]) {
            'A' -> if (x < N - 2 && S[x + 1] == 'B' && S[x + 2] == 'C') {
                n--
            }

            'B' -> if (x > 0 && x < N - 1 && S[x - 1] == 'A' && S[x + 1] == 'C') {
                n--
            }

            'C' -> if (x > 1 && S[x - 2] == 'A' && S[x - 1] == 'B') {
                n--
            }
        }
        when (c) {
            'A' -> if (x < N - 2 && S[x + 1] == 'B' && S[x + 2] == 'C') {
                n++
            }

            'B' -> if (x > 0 && x < N - 1 && S[x - 1] == 'A' && S[x + 1] == 'C') {
                n++
            }

            'C' -> if (x > 1 && S[x - 2] == 'A' && S[x - 1] == 'B') {
                n++
            }
        }
        S[x] = c
        println(n)
    }
}
