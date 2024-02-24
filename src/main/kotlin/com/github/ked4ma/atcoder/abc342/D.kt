package com.github.ked4ma.atcoder.abc342

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.combimation.*
import kotlin.math.sqrt

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()

    fun primes(n: Int): List<Int> {
        val L = sqrt(n.toDouble()).toInt() + 1
        val arr = BooleanArray(L + 1)
        return buildList {
            for (i in 2..sqrt(n.toDouble()).toInt() + 1) {
                if (arr[i]) continue
                add(i)
                for (j in i until L + 1 step i) {
                    arr[j] = true
                }
            }
        }
    }

    val pList = primes(200000)
    _debug_println(pList)
    _debug_println(pList.size)

    val map = mutableMapOf<Int, Int>()
    var zeros = 0
    for (a in A) {
        if (a == 0) {
            zeros++
            continue
        }
        var n = a
        pList.forEach { p ->
            while (n % (p * p) == 0) {
                n /= (p * p)
            }
        }
        map[n] = map.getOrDefault(n, 0) + 1
    }
    _debug_println(zeros)
    _debug_println(map)
    var ans = 0L
    repeat(zeros) {
        ans += N - it - 1
    }
    map.forEach { (_, n) ->
        if (n < 2) return@forEach
        ans += combination(n.toLong(), 2)
    }
    println(ans)
}