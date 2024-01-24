package com.github.ked4ma.atcoder.abc327

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val A: List<List<Int>> = times(9) {
        nextIntList()
    }
    // rows
    for (row in A) {
        _debug_println(row)
        if (row.toSet().size != 9) {
            println("No")
            return
        }
    }
    repeat(9) { j ->
        _debug_println(A.map { it[j] })
        if (A.map { it[j] }.toSet().size != 9) {
            println("No")
            return
        }
    }
    repeat(3) { m ->
        repeat(3) { n ->
            val set = buildSet {
                repeat(3) { i ->
                    repeat(3) { j ->
                        add(A[m * 3 + i][n * 3 + j])
                    }
                }
            }
            _debug_println(set)
            if (set.size != 9) {
                println("No")
                return
            }
        }
    }
    println("Yes")
}