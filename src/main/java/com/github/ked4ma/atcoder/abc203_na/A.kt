package com.github.ked4ma.atcoder.abc203_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val nums = nextIntList().take(3)
    val set = mutableSetOf<Int>()
    for (n in nums) {
        if (n in set) {
            set.remove(n)
        } else {
            set.add(n)
        }
    }
    if (set.size == 1) {
        println(set.first())
    } else {
        println(0)
    }
}
