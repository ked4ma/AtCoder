package com.github.ked4ma.atcoder.abc102_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*
import kotlin.math.abs

fun main() {
    nextInt()
    nextIntList().let {
        println(abs((it.max() ?: 0) - (it.min() ?: 0)))
    }
}
