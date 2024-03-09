package com.github.ked4ma.atcoder.abc344

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val M = nextInt()
    val B = nextIntList()
    val L = nextInt()
    val C = nextIntList()
    val Q = nextInt()
    val X = nextIntList()

    val S = buildSet {
        A.forEach { a ->
            B.forEach { b ->
                C.forEach { c ->
                    add(a + b + c)
                }
            }
        }
    }

    X.forEach {
        println(if (it in S) "Yes" else "No")
    }
}