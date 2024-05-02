package com.github.ked4ma.atcoder.utils.number.base

fun numToArr(num: Int, base: Int, size: Int = -1): IntArray {
    var n = num
    var s = size
    return buildList {
        while (n > 0 || s > 0) {
            add(n % base)
            n /= base
            s--
        }
    }.toIntArray()
}

fun arrToNum(arr: IntArray, base: Int): Int {
    var n = 0
    (arr.size - 1 downTo 0).forEach { i ->
        n *= base
        n += arr[i]
    }
    return n
}