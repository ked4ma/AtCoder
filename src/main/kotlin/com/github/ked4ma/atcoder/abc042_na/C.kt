package com.github.ked4ma.atcoder.abc042_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val (n, _) = nextIntList()
    val v = nextIntList().toSet().let {
        (0..9).filterNot { v -> v in it }
    }
    v.forEach {
        if (it >= n) {
            println(it)
            return
        }
    }
    var s = v.filterNot { it == 0 }.toSet()
    repeat(4) {
        val ns = mutableSetOf<Int>()
        s.forEach { a ->
            v.forEach { b ->
                val c = a.times(10) + b
                if (c >= n) {
                    println(c)
                    return
                }
                ns.add(c)
            }
        }
        s = ns
    }
}
