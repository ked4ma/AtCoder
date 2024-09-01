package com.github.ked4ma.atcoder.abc369

import com.github.ked4ma.atcoder.utils.array.int.bound.*
import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, N) = nextIntList()
    val coins = times(N) {
        val (R, C) = nextIntList()
        R to C
    }.sortedWith(compareBy({ it.first }, { it.second }))

    val arr = sizedIntArray(N, Int.MAX_VALUE)
    val id = sizedIntArray(N, -1)
    val pre = sizedIntArray(N, -1)
    for (i in range(N)) {
        val it = arr.upperBound(coins[i].second)
        arr[it] = coins[i].second
        id[it] = i
        pre[i] = if (it > 0) id[it - 1] else -1
    }
    var m = N - 1
    while (id[m] == -1) m--
    val path = mutableListOf((H to W))
    var now = id[m]
    while (now != -1) {
        path.add(coins[now])
        now = pre[now]
    }
    path.add(1 to 1)
    path.reverse()
    val sb = StringBuilder()
    for (i in range(path.size - 1)) {
        val d = path[i +1].first - path[i].first
        val r = path[i + 1].second - path[i].second
        sb.append("D".repeat(d))
        sb.append("R".repeat(r))
    }
    println(m + 1)
    println(sb)
}
