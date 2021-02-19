package com.github.khronos227.atcoder.abc109_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val N = nextInt()
    val words = (0 until N).map {
        next()
    }
    val wordSet = words.toSet()

    if (words.size != wordSet.size) {
        println("No")
        return
    }

    for (index in (0 until N - 1)) {
        if (words[index].last() != words[index + 1].first()) {
            println("No")
            return
        }
    }
    println("Yes")
}
