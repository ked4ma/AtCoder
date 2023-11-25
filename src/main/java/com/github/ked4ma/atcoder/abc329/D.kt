package com.github.ked4ma.atcoder.abc329

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()
    val count = sizedArray(N + 1, 0)
    val map = mutableMapOf(0 to (1..N).toSortedSet())
    val queue = PriorityQueue<Int>(Comparator.reverseOrder())
    for (a in A) {
        map.getValue(count[a]).remove(a)
        count[a]++
        map.putIfAbsent(count[a], sortedSetOf())
        map.getValue(count[a]).add(a)
        queue.add(count[a])
        println(map.getValue(queue.peek()).first())
    }
}