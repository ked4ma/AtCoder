package com.github.ked4ma.atcoder.abc359

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.tree.segment.lazy.*
import com.github.ked4ma.atcoder.utils.repeat.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val H = nextLongList()
    val segTree = LazySegmentTree.RUQ_RSQ(N + 1)
    val hQueue = Stack<Pair<Long, Int>>()
    hQueue.push(Long.MAX_VALUE to 0)
    val ans = StringJoiner(" ")
    for (i in range(N)) {
        val h = H[i]
        while (h > hQueue.peek().first) {
            hQueue.pop()
        }
        segTree.update(hQueue.peek().second, i + 1, h)
        ans.add((segTree.query(0, i + 1) + 1).toString())
        hQueue.add(h to i + 1)
    }
    println(ans)
}
