package com.github.khronos227.atcoder.abc179

import com.github.khronos227.atcoder.utils.*
import kotlin.math.sqrt

fun main() {
    var count = 0
    val n = nextInt()
    val dicstra = sizedArray(sqrt(n.toDouble()).toInt() + 1, true)
    (2..sqrt(n.toDouble()).toInt()).mapNotNull {
        (it * 2 until dicstra.size step it).forEach {
            dicstra[it] = false
        }
    }
    val primes = dicstra.mapIndexedNotNull { index, b ->
        if (index >= 2 && b) index else null
    }

    (1..n.minus(1)).forEach { c ->
        var cnt = 1
        var m = n - c
        primes.forEach inner@ { a ->
            if (m % a != 0) return@inner
            var ex = 0

            while (m % a == 0) {
                ex++
                m /= a
            }
            cnt *= ex.plus(1)
        }
        if (m != 1) cnt *= 2
        count += cnt
    }
    println(count)
}
