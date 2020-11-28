package com.github.khronos227.atcoder.abc171

import com.github.khronos227.atcoder.utils.*

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
