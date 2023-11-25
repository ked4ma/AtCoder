package com.github.ked4ma.atcoder.abc199_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    val N = nextInt()
    val S = next().toCharArray()
    val Q = nextInt()
    var isFlipped = false
    repeat(Q) {
        var (T, A, B) = nextIntList()
        if (T == 1) {
            A-- // convert to 0-index base
            B-- // convert to 0-index base
            if (isFlipped) {
                A = (A + N) % (2 * N)
                B = (B + N) % (2 * N)
            }
            val tmp = S[A]
            S[A] = S[B]
            S[B] = tmp
        } else { // T == 2
            isFlipped = !isFlipped
        }
    }
    val result = if (isFlipped) {
        S.copyOfRange(N, 2 * N) + S.copyOfRange(0, N)
    } else {
        S
    }.concatToString()
    println(result)
}
