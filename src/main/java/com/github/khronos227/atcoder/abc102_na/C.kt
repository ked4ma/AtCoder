package com.github.khronos227.atcoder.abc102_na

import com.github.khronos227.atcoder.utils.*
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.min

fun main() {
    nextInt()
    val values = nextLongList().mapIndexed { index, l -> l - index.plus(1) }
    val mid = values.sorted().let {
        if (it.size % 2 == 1) {
            it[it.size / 2].toDouble()
        } else {
            (it[it.size / 2] + it[it.size / 2 - 1]).toDouble() / 2
        }
    }
    println(
        min(
            values.map {
                abs(it - floor(mid).toLong())
            }.sum(),
            values.map {
                abs(it - ceil(mid).toLong())
            }.sum()
        )
    )
}
