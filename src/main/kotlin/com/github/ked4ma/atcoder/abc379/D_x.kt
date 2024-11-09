package com.github.ked4ma.atcoder.abc379

import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val Q = nextInt()
    val queue = ArrayDeque<Int>()
    val hArr = sizedLongArray(Q + 1, 0)
    repeat(Q) {
        val q = nextIntList()
        hArr[it + 1] = hArr[it]
        when (q[0]) {
            1 -> {
                queue.add(it)
            }

            2 -> {
                hArr[it + 1] += q[1].toLong()
            }

            3 -> {
                var ans = 0
                while (queue.isNotEmpty() && hArr[it] - hArr[queue.first()] >= q[1]) {
                    ans++
                    queue.removeFirst()
                }
                println(ans)
            }
        }
    }
}