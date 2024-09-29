package com.github.ked4ma.atcoder.abc373

import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import java.util.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, W) = nextIntList()
    val items = times(N) {
        val (w, v) = nextLongList()
        w.toInt() to v
    }
    val f: Map<Int, List<Long>> = items.groupBy(
        keySelector = { it.first },
        valueTransform = { it.second },
    ).entries.associate { (w, vs) ->
        w to buildList {
            var sum = 0L
            add(sum)
            val queue = PriorityQueue<Long>(Collections.reverseOrder())
            queue.addAll(vs.map { it - 1 })
            repeat(W / w) {
                val v = queue.poll()
                sum += v
                add(sum)
                queue.offer(v - 2)
            }
        }
    }
    val dp = sizedLongArray(W + 1, 0)
    dp[0] = 0

    for (w in range(W + 1)) {
        if (w !in f) continue
        for (j in range(W).reversed()) {
            var k = 1
            while (j + k * w <= W) {
                dp[j + k * w] = max(dp[j + k * w], dp[j] + f.getValue(w)[k])
                k++
            }
        }
    }
    println(dp.max())
}
