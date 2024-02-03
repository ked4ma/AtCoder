package com.github.ked4ma.atcoder.abc339

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val dirs = arrayOf(
        -1 to 0, // ↑
        0 to 1,  // ➔
        1 to 0,  // ↓
        0 to -1  // ←
    )
    val (H, W, N) = nextIntList()
    val G = Array(H) { CharArray(W) { '.' } }
    var d = 0
    var h = 0
    var w = 0
    repeat(N) {
        if (G[h][w] == '.') {
            G[h][w] = '#'
            d = (d + 1) % 4
        } else {
            G[h][w] = '.'
            d = (d + 3) % 4
        }
        h = (h + H + dirs[d].first) % H
        w = (w + W + dirs[d].second) % W
    }
    G.forEach {
        println(it.joinToString(""))
    }
}