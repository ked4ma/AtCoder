package com.github.ked4ma.atcoder.abc364

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextIntList().sorted()

    /**
     * ref: https://webbibouroku.com/Blog/Article/cs-lowerbound-upperbound
     */
    fun lowerBound(list: List<Int>, value: Int): Int {
        var left = 0
        var right = list.lastIndex
        while (left <= right) {
            val mid = (left + right) / 2
            if (list[mid] < value) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return left
    }

    /**
     * ref: https://webbibouroku.com/Blog/Article/cs-lowerbound-upperbound
     */
    fun upperBound(list: List<Int>, value: Int): Int {
        var left = 0
        var right = list.lastIndex
        while (left <= right) {
            val mid = (left + right) / 2
            if (list[mid] <= value) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return left
    }

    fun f(b: Int, x: Int): Int {
        val lb = lowerBound(A, b - x)
        val ub = upperBound(A, b + x)
        // _debug_println("$x: $lb $ub")
        return ub - lb
    }
    repeat(Q) {
        val (b, k) = nextIntList()
        var ng = -1
        var ok = Int.MAX_VALUE / 2
        while (ng + 1 < ok) {
            val m = (ok + ng) / 2
            if (f(b, m) >= k) {
                ok = m
            } else {
                ng = m
            }
        }
        println(ok)
    }
}
