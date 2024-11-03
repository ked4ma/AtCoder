package com.github.ked4ma.atcoder.abc378

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, K) = nextIntList()
    val S = times(H) { nextCharArray() }

    val dirs = listOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1,
    )

    fun dfs(h: Int, w: Int, k: Int): Int {
        if (k == 0) return 1
        var res = 0
        S[h][w] = '!'
        for ((dh, dw) in dirs) {
            val nh = h + dh
            val nw = w + dw
            if (nh in range(H) && nw in range(W) && S[nh][nw] == '.') {
                res += dfs(nh, nw, k - 1)
            }
        }
        S[h][w] = '.'
        return res
    }

    var ans = 0
    for (h in range(H)) {
        for (w in range(W)) {
            if (S[h][w] == '.') {
                ans += dfs(h, w, K)
            }
        }
    }
    println(ans)
}
