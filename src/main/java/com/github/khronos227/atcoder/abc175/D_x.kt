package com.github.khronos227.atcoder.abc175

import com.github.khronos227.atcoder.utils.*
import kotlin.math.max

fun main() {
    val (n, k) = nextIntList()
    val p = nextIntList().map { it - 1 }
    val c = nextLongList()

    var res = Long.MIN_VALUE
    repeat(n) {
        var index = p[it]
        val l = mutableListOf<Int>()
        while (index != l.getOrNull(0)) {
            l.add(index)
            index = p[index]
        }

        var v = Long.MIN_VALUE
        var inner = 0L
        l.take(k).forEach { i ->
            inner += c[i]
            v = max(v, inner)
        }

        if (inner > 0 && k > l.size) {
            val num = k.minus(1).div(l.size)
            inner = inner.times(num)
            l.take(k.minus(l.size.times(num))).forEach { i ->
                inner += c[i]
                v = max(v, inner)
            }
        }
        res = max(res, v)
    }
    println(res)
}
