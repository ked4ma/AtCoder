package com.github.ked4ma.atcoder.abc104_na

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.min

fun main() {
    val (d, g) = nextIntList()
    val countList = mutableListOf<Int>()
    val estList = mutableListOf<List<Int>>()
    repeat(d) {
        val v = it.plus(1).times(100)
        val (p, c) = nextIntList()
        countList.add(p)
        val list = mutableListOf<Int>()
        (0 until p).forEach {
            list.add(v * it)
        }
        list.add(v * p + c)
        estList.add(list)
    }
//    println(countList)
//    println(estList)

    fun dfs(_d: Int, n: Int): Int {
        if (_d < d) {
            return min(
                dfs(_d + 1, (n shl 1)),
                dfs(_d + 1, (n shl 1) or 1)
            )
        }
        val list = mutableListOf<Int>()
        var m = n
        var s = 0
        var c = 0
        repeat(d) {
            val b = m and 1
            m = m shr 1
//            print("$b ")

            if (b == 1) {
                s += estList[it].last()
                c += countList[it]
            } else {
                list.add(it)
            }
        }
//        println(n)
//        println("s: $s, c: $c")
//        println(list)
        if (s >= g) return c
        return list.map { i ->
            val index = estList[i].indexOfFirst {
                s + it >= g
            }
            if (index >= 0) {
                c + index
            } else {
                Int.MAX_VALUE
            }
        }.min() ?: Int.MAX_VALUE
    }

    println(dfs(0, 0))
}
