package com.github.ked4ma.atcoder.abc332

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (K, G, M) = nextLongList()
    var g = 0L
    var m = 0L
    loop(K) {
        when {
            g == G -> g = 0L
            m == 0L -> m = M
            else -> {
                val v = min(m, G - g)
                g += v
                m -= v
            }
        }
        _debug_println("$g $m")
    }
    println("$g $m")
}