package com.github.ked4ma.atcoder.abc339

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val P = mutableListOf<Pair<Int, Int>>()
    val S = times(N) { i ->
        val s = next()
        for (j in 0 until N) {
            if (s[j] == 'P') {
                P.add(i to j)
            }
        }
        s.toCharArray()
    }
    val dirs = arrayOf(
        -1 to 0, // ↑
        0 to 1,  // ➔
        1 to 0,  // ↓
        0 to -1  // ←
    )
    val dis = Array(N) { Array(N) { Array(N) { LongArray(N) { Long.MAX_VALUE } } } }
    dis[P[0].first][P[0].second][P[1].first][P[1].second] = 0
    val queue = ArrayDeque<IntArray>()
    queue.add(P.flatMap { it.toList() }.toIntArray())
    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()
        dirs.forEach { (dh, dw) ->
            val nxt = cur.copyOf()
            if (nxt[0] + dh in 0 until N && nxt[1] + dw in 0 until N && S[nxt[0] + dh][nxt[1] + dw] != '#') {
                nxt[0] += dh
                nxt[1] += dw
            }
            if (nxt[2] + dh in 0 until N && nxt[3] + dw in 0 until N && S[nxt[2] + dh][nxt[3] + dw] != '#') {
                nxt[2] += dh
                nxt[3] += dw
            }
            if (dis[nxt[0]][nxt[1]][nxt[2]][nxt[3]] == Long.MAX_VALUE) {
                dis[nxt[0]][nxt[1]][nxt[2]][nxt[3]] = dis[cur[0]][cur[1]][cur[2]][cur[3]] + 1
                queue.add(nxt)
            }
        }
    }
    var ans = Long.MAX_VALUE
    for (i in 0 until N) {
        for (j in 0 until N) {
            ans = min(ans, dis[i][j][i][j])
        }
    }
    println(if (ans == Long.MAX_VALUE) -1 else ans)
}