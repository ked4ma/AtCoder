package com.github.khronos227.atcoder.abc061_na

import com.github.khronos227.atcoder.utils.*

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
