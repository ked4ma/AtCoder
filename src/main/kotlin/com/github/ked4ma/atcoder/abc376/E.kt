package com.github.ked4ma.atcoder.abc376

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import java.util.*
import kotlin.math.min

fun main() {
    val T = nextInt()
    repeat(T) {
        case()
    }
}

private fun case() {
    val (N, K) = nextIntList()
    val AB = buildList {
        val A = nextLongList()
        val B = nextLongList()
        for (i in range(N)) {
            add(A[i] to B[i])
        }
    }.sortedBy { it.first }
    val queue = PriorityQueue<Long>(reverseOrder())
    for (i in range(K - 1)) {
        queue.add(AB[i].second)
    }
    var sum = queue.sum()
    var ans = Long.MAX_VALUE
    for (i in K - 1 until N) {
        queue.add(AB[i].second)
        sum += AB[i].second
        while (queue.size > K) {
            sum -= queue.poll()
        }
        ans = min(ans, AB[i].first * sum)
    }
    println(ans)
}
