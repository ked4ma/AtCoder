package com.github.ked4ma.atcoder.abc366

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val Q = nextInt()
    var ans = 0
    val arr = sizedIntArray(1_000_001, 0)
    repeat(Q) {
        val q = nextIntList()
        when (q[0]) {
            1 -> {
                if (arr[q[1]] == 0) {
                    ans++
                }
                arr[q[1]]++
            }

            2 -> {
                arr[q[1]]--
                if (arr[q[1]] == 0) {
                    ans--
                }
            }

            3 -> {
                println(ans)
            }
        }
    }
}
