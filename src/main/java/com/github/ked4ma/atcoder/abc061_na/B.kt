package com.github.ked4ma.atcoder.abc061_na

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    val (n, m) = nextIntList()
    val cntArr = sizedArray(n, 0)
    repeat(m) {
        val (a, b) = nextIntList()
        cntArr[a - 1]++
        cntArr[b - 1]++
    }
    cntArr.forEach(::println)
}
