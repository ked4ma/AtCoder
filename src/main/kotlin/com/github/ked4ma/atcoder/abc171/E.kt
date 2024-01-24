package com.github.ked4ma.atcoder.abc171

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    var n = 0
    nextInt()
    val values = nextIntList()
    values.forEach {
        n = n xor it
    }
    values.forEach {
        print(n xor it)
        if (it == values.lastIndex) {
            println()
        } else {
            print(' ')
        }
    }
}
