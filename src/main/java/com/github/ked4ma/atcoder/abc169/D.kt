package com.github.ked4ma.atcoder.abc169

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.sqrt

fun main() {
    var n = nextLong()
    val primeCounts = mutableMapOf<Long, Int>()
    val sieve = sizedArray(sqrt(n.toDouble()).toInt() + 1, true)
    sieve[0] = false
    sieve[1] = false
    sieve.indices.forEach {
        if (!sieve[it]) return@forEach
        // check gcd
        while (n % it == 0L) {
            n /= it
            primeCounts[it.toLong()] = primeCounts.getOrDefault(it.toLong(), 0) + 1
        }
        // update sieve
        var index = it + it
        while (index <= sieve.lastIndex) {
            sieve[index] = false
            index += it
        }
    }
    if (n >= sieve.size) {
        primeCounts[n] = 1
    }
    var res = 0
    primeCounts.forEach { (_, value) ->
        var count = value
        var num = 1
        while (num <= count) {
            count -= num
            num++
            res++
        }
    }
    println(res)
}
