package com.github.ked4ma.atcoder.abc280_na

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.sqrt

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val primes = mutableSetOf<Long>()
    fun calcPrimes(n: Long): List<Long> {
        return buildList {
            var k = n
            (2..sqrt(n.toDouble()).toLong()).forEach {
                while (k % it == 0L) {
                    primes.add(it)
                    add(it)
                    k /= it
                }
            }
            if (k != 1L) {
                primes.add(k)
                add(k)
            }
        }
    }

    val K = nextLong()
    val require = calcPrimes(K).groupingBy { it }.eachCount()
    var l = 0L
    var r = K
    while (l < r) {
        val mid = (l + r) / 2
        val counts = mutableMapOf<Long, Long>()
        primes.forEach { p ->
            var n = p
            while (n <= mid) {
                counts[p] = counts.getOrDefault(p, 0) + mid / n
                n *= p
            }
        }
        if (require.all { (k, c) -> c <= counts.getOrDefault(k, 0) }) {
            r = mid
        } else {
            l = mid + 1
        }
    }
    println(r)
//    var max = list.max()
//    val counts = mutableMapOf<Long, Long>()
//    primes.forEach { p ->
//        var n = p
//        while (n <= max) {
//            counts[p] = counts.getOrDefault(p, 0) + max / n
//            n *= p
//        }
//    }
//    _debug_println(list)
//    _debug_println(max)
//    _debug_println(primes)
//    _debug_println(counts)
//    _debug_println(list.groupingBy { it }.eachCount())
//    _debug_println(list.groupingBy { it }.eachCount().any { (k, c) -> c > counts.getOrDefault(k, 0) })
//    var rack = 1L
//    require.forEach { (k, c) ->
//        rack *= k.pow((c - counts.getOrDefault(k, 0)).coerceAtLeast(0L).toInt())
//    }
//    if (rack > 1L) {
//        var x = rack
//        while (x <= max) {
//            x += rack
//        }
//        max = x
//    }

//    while (require.any { (k, c) -> c > counts.getOrDefault(k, 0) }) {
//        max++
//        calcPrimes(max).forEach { p ->
//            counts[p] = counts.getOrDefault(p, 0) + 1
//        }
//    }

//    println(max)
}