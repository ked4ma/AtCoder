package com.github.khronos227.atcoder.arc110

import com.github.khronos227.atcoder.utils.*

fun main() {
    val n = nextInt()
    val p = nextIntList()
    val memo = sizedArray(n - 1, true)
    val list = mutableListOf(p.first())

    val ans = mutableListOf<Int>()
    for (i in 1..p.lastIndex) {
        var j = list.lastIndex
        while (j >= 0 && p[i] < list[j]) {
            if (memo[j]) {
                ans.add(j + 1)
                memo[j] = false
                j--
            } else {
                println(-1)
                return
            }
        }
        list.add(j + 1, p[i])
        // println(list)
    }
    if (memo.all { !it }) {
        ans.forEach {
            println(it)
        }
    } else {
        println(-1)
    }
}
