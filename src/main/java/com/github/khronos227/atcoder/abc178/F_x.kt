package com.github.khronos227.atcoder.abc178

import com.github.khronos227.atcoder.utils.*

fun main() {
    val n = nextInt()
    val a = nextIntList()
    val b = nextIntList()
    var bIndex = 0
    val result = mutableListOf<Int>()
    val stock = mutableListOf<Int>()

    a.forEach {
        while (bIndex < n && b[bIndex] == it) {
            stock.add(b[bIndex])
            bIndex++
        }
        if (bIndex >= n) return@forEach
        result.add(b[bIndex])
        bIndex++
    }
    when {
        stock.isNotEmpty() && a[result.size] == stock.first() -> println("No")
        else -> {
            println("Yes")
            println((result + stock).joinToString(separator = " "))
        }
    }
}
