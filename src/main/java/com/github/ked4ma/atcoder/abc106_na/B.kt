package com.github.ked4ma.atcoder.abc106_na

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    val n = nextInt()
    // init sieve
    val sieve = sizedArray(n + 1, true)
    sieve[0] = false
    sieve[1] = false
    for (i in 2..n) {
        if (!sieve[i]) continue
        for (j in (i + i)..n step i) {
            sieve[j] = false
        }
    }
    val primes = sieve.mapIndexedNotNull { index, b -> if (b) index else null }
    val arr = sizedArray(n + 1, 0)
    arr[1] = 1
    var count = 0
    for (i in 1..n step 2) {
        var num = i
        var index = 0
        var sub = 1
        while (num > 1) {
            var c = 0
            while (num % primes[index] == 0) {
                c++
                num /= primes[index]
            }
            if (c > 0) {
                sub *= (c + 1)
            }
            index++
        }
        if (sub == 8) {
            count++
        }
    }
    println(count)
}
