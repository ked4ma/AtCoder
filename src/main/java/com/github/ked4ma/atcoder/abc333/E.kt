package com.github.ked4ma.atcoder.abc333

import com.github.ked4ma.atcoder.utils.array.*
import com.github.ked4ma.atcoder.utils.array.default.*
import com.github.ked4ma.atcoder.utils.array.long.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.default.*
import com.github.ked4ma.atcoder.utils.loop.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    val E = times(N) {
        val (t, x) = nextLongList()
        t to x - 1
    }
    val arr = sizedArray(N) { mutableListOf<Long>() }
    val chk = sizedLongArray(N) { 0L }
    E.forEachIndexed { index, (t, x) ->
        if (t == 1L) {
            arr[x].add(index.toLong())
        } else { // t == 2
            if (arr[x].isEmpty()) {
                println(-1)
                return
            } else {
                chk[arr[x].last()] = 1L
                arr[x].removeLast()
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