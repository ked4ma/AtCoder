package com.github.ked4ma.atcoder.abc052_na

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*
import com.github.ked4ma.atcoder.utils.math.*

fun main() {
    val mod = 1_000_000_007L
    val sieve = sizedArray(1_000 + 1, true)
    sieve[0] = false
    sieve[1] = false
    repeat(1001) { index ->
        if (!sieve[index]) return@repeat
        var current = index * 2
        while (current <= sieve.lastIndex) {
            sieve[current] = false
            current += index
        }
    }
    val primes = sieve.mapIndexedNotNull { index, b ->
        if (b) index else null
    }
    val n = nextInt()
    val countMap = mutableMapOf(1 to 0L)
    (2..n).forEach {
        var v = it
        var index = 0
        while (v > 1 && index < primes.size && v >= primes[index]) {
            while (v % primes[index] == 0) {
                v /= primes[index]
                countMap[primes[index]] = countMap.getOrDefault(primes[index], 0) + 1
            }
            index++
        }
    }
    println(countMap.values.map { it + 1 }.reduce { acc, i -> acc.times(i, mod) })
}
