package com.github.khronos227.atcoder.aising2020_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    nextInt()
    val list = nextIntList()
    println(list.filterIndexed { index, i ->
        index % 2 == 0 && i % 2 == 1
    }.size)
}
