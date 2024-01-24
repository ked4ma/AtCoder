package com.github.ked4ma.atcoder.abc333

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.cumlative.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    val E = timesWithLong(N) {
        val (t, x) = nextLongList()
        t to x - 1
    }
    val arr = sizedArray(N.toInt()) { mutableListOf<Long>() }
    val chk = sizedLongArray(N.toInt()) { 0L }
    E.forEachIndexed { index, (t, x) ->
        if (t == 1L) {
            arr[x.toInt()].add(index.toLong())
        } else { // t == 2
            if (arr[x.toInt()].isEmpty()) {
                println(-1)
                return
            } else {
                chk[arr[x.toInt()].last().toInt()] = 1L
                arr[x.toInt()].removeLast()
            }
        }
    }
    chk.mapIndexed { index, l ->
        if (E[index].first == 2L) {
            -1L
        } else {
            l
        }
    }.cumulativeSum().max().let {
        println(it)
    }
    println(chk.filterIndexed { index, _ -> E[index].first == 1L }.joinToString(" "))
}