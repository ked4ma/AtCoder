package com.github.ked4ma.atcoder.abc045_na

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*
import kotlin.math.min

fun main() {
    val (h, w, n) = nextIntList()
    val list = mutableListOf<Pair<Int, Int>>()

    repeat(n) {
        val (a, b) = nextIntList()
        ((a - 3).coerceAtLeast(0) until min(a, h - 2)).forEach { da ->
            ((b - 3).coerceAtLeast(0) until min(b, w - 2)).forEach { db ->
                val p = da to db
                list.add(p)
            }
        }
    }
    val countArr = sizedArray(9, 0)
    if (list.isNotEmpty()) {
        list.sortWith(Comparator { o1, o2 ->
            val a = o1.first.compareTo(o2.first)
            if (a == 0) {
                o1.second.compareTo(o2.second)
            } else {
                a
            }
        })
        var count = 0
        var current = list.first()
        list.forEach {
            if (current == it) {
                count++
                return@forEach
            }
            countArr[count - 1]++
            current = it
            count = 1
        }
        countArr[count - 1]++
    }
    println((h.toLong().minus(2) * w.toLong().minus(2)) - countArr.sum())
    (1..9).forEach {
        println(countArr[it - 1])
    }
}
