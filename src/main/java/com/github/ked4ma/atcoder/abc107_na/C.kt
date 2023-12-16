package com.github.ked4ma.atcoder.abc107_na

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*
import kotlin.math.min

fun main() {
    val (N, K) = nextIntList()
    _debug_println("$N $K")
    val data = nextLongList()
    val nutoralIndex = data.indexOfFirst { it >= 0 }

    val posAcc: LongArray
    val negAcc: LongArray
    if (nutoralIndex < 0) {
        posAcc = LongArray(N + 1)
        repeat(N) {
            posAcc[it + 1] = -data[N - it - 1]
        }
        negAcc = LongArray(1)
    } else {
        posAcc = LongArray(N - nutoralIndex + 1)
        repeat(N - nutoralIndex) {
            posAcc[it + 1] = data[nutoralIndex + it]
        }
        negAcc = LongArray(nutoralIndex + 1)
        repeat(nutoralIndex) {
            negAcc[it + 1] = -data[nutoralIndex - it - 1]
        }
    }
    _debug_println(posAcc.joinToString(", "))
    _debug_println(negAcc.joinToString(", "))
    var posIndex = min(posAcc.lastIndex, K)
    var negIndex = K - (posIndex)
    var ans = min(
        posAcc[posIndex] + 2 * negAcc[negIndex],
        2 * posAcc[posIndex] + negAcc[negIndex]
    )
    _debug_println(posIndex)
    _debug_println(negIndex)
    _debug_println(ans)
    while (negIndex < min(negAcc.lastIndex, K)) {
        posIndex--
        negIndex++
        val candidate = min(
            posAcc[posIndex] + 2 * negAcc[negIndex],
            2 * posAcc[posIndex] + negAcc[negIndex]
        )
        if (candidate < ans) {
            ans = candidate
            _debug_println("$posIndex $negIndex $ans")
        }
    }
    println(ans)
}
