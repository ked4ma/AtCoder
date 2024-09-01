package com.github.ked4ma.atcoder.abc369

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var l = 0
    var r = 0

    var ans = 0
    repeat(N) {
        val (A, S) = nextList().let { (A, S) -> A.toInt() to S }
        when (S) {
            "L" -> {
                if (l > 0) {
                    ans += abs(l - A)
                }
                l = A
            }

            "R" -> {
                if (r > 0) {
                    ans += abs(r - A)
                }
                r = A
            }
        }
    }
    println(ans)
}
