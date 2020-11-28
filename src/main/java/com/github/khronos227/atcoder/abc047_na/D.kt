package com.github.khronos227.atcoder.abc047_na

import com.github.khronos227.atcoder.utils.*
import kotlin.math.max

fun main() {
    nextIntList()
    val v = nextIntList()
    var m = v.first()
    var mDiff = 0
    v.forEach {
        if (m > it) {
            m = it
            return@forEach
        }
        mDiff = max(mDiff, it - m)
    }

    val target = mDiff - 1
    var cost = 0
    m = v.first()
    v.forEach {
        if (m > it) {
            m = it
            return@forEach
        }
        val diff = it - m
        if (diff > target) {
            cost += diff - target
        }
    }

    println(cost)
}
