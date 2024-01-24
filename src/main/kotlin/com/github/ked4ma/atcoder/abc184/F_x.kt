package com.github.ked4ma.atcoder.abc184

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.max

fun main() {
    val (_, t) = nextLongList().let { (n, t) -> n.toInt() to t }
    val a = nextLongList()

    fun merge(list: List<Long>, x: Long): List<Long> {
        val res = mutableListOf<Long>()
        var i = 0
        for (v in list) {
            while (list[i] + x < v) {
                res.add(list[i] + x)
                i++
            }
            res.add(v)
        }
        while (i < list.size) {
            res.add(list[i] + x)
            i++
        }
        return res
    }

    var bList = listOf(0L)
    for (i in 0 until a.size / 2) {
        bList = merge(bList, a[i])
    }
    var cList = listOf(0L)
    for (i in a.size / 2 until a.size) {
        cList = merge(cList, a[i])
    }
    cList = cList.asReversed()

    var ans = 0L
    var cIndex = 0
    for (x in bList) {
        if (x > t) break
        while (x + cList[cIndex] > t) {
            cIndex++
        }
        ans = max(ans, x + cList[cIndex])
    }

    println(ans)
}
