package com.github.ked4ma.atcoder.abc182

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.sqrt

fun main() {
    nextInt()
    val a = nextIntList()
    val count = sizedArray((a.max() ?: 0) + 1, 0)
    a.forEach { num ->
        count[num]++
        val r = sqrt(num.toDouble()).toInt()
        for (i in 2..r) {
            if (num % i == 0) {
                count[i]++
                count[num / i]++
            }
        }
    }
    var index = 0
    var value = 0
    count.forEachIndexed { i, v ->
        if (value < v) {
            index = i
            value = v
        }
    }
    println(index)
}
