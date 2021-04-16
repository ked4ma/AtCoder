package com.github.khronos227.atcoder.abc189_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val N = nextInt()
    var trueCount = 1L
    var falseCount = 1L

    repeat(N) { _ ->
        when (next()) {
            "AND" -> {
                val ntc = trueCount
                val nfc = trueCount + 2 * falseCount
                trueCount = ntc
                falseCount = nfc
            }
            "OR" -> {
                val ntc = 2 * trueCount + falseCount
                val nfc = falseCount
                trueCount = ntc
                falseCount = nfc
            }
        }
        _debug_println("${trueCount}:${falseCount}")
    }
    println(trueCount)
}
