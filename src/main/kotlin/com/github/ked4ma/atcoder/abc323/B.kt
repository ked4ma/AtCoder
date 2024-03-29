package com.github.ked4ma.atcoder.abc323

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    timesWithLong(N.toLong()) { i ->
        next().let {
            i + 1 to it.filter { c -> c == 'o' }.length
        }
    }.groupBy {
        it.second
    }.entries.sortedByDescending {
        it.key
    }.map { (_, value) ->
        value.sortedBy { it.first }.map {
            it.first
        }
    }.flatten().let {
        println(it.joinToString(separator = " "))
    }
}