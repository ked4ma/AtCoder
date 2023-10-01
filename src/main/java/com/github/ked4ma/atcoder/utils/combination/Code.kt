package com.github.ked4ma.atcoder.utils.combination

fun combination(m: Int, n: Int): Long = combination(m, n, mutableMapOf()).first

fun combination(m: Int, n: Int, memo: MutableMap<Pair<Int, Int>, Long>): Pair<Long, Map<Pair<Int, Int>, Long>> {
    if (m < 0 || n < 0) throw IllegalArgumentException("m and n must be positive")
    if (m < n) throw IllegalArgumentException("m must be larger than n")

    fun comb(a: Int, b: Int): Long {
        if (b == 0 || a == b) return 1L
        if (b == 1) return a.toLong()
        val l = memo.getOrPut(a - 1 to b - 1) {
            comb(a - 1, b - 1)
        }
        val r = memo.getOrPut(a - 1 to b) {
            comb(a - 1, b)
        }
        return l + r
    }

    return comb(m, n) to memo
}

