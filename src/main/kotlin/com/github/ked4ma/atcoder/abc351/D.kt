package com.github.ked4ma.atcoder.abc351

import com.github.ked4ma.atcoder.utils.array.boolean.d2.*
import com.github.ked4ma.atcoder.utils.array.int.d2.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val S = times(H) {
        next().toCharArray()
    }
    // 3 5
    // !#!..
    // .!..!
    // !#!!#
    val dirs = listOf(
        0 to 1,
        1 to 0,
        0 to -1,
        -1 to 0,
    )
    for (i in range(H)) {
        for (j in range(W)) {
            if (S[i][j] == '#') {
                for ((dh, dw) in dirs) {
                    val h = i + dh
                    val w = j + dw
                    if (h < 0 || h >= H || w < 0 || w >= W || S[h][w] == '#') continue
                    S[h][w] = '!'
                }
            }
        }
    }
    S.forEach { _debug_println(it.joinToString("")) }

    var ans = 1
    val group = sized2DIntArray(H, W, -1)
    val queue = ArrayDeque<Pair<Int, Int>>()
    for (i in range(H)) {
        for (j in range(W)) {
            if (S[i][j] == '!' || S[i][j] == '#' || group[i][j] != -1) continue
            queue.addLast(i to j)
            var res = 0
            while (queue.isNotEmpty()) {
                val (h, w) = queue.removeFirst()
                if (h < 0 || h >= H || w < 0 || w >= W || S[h][w] == '#' || group[h][w] == i * W + j) continue
                group[h][w] = i * W + j
                res++
                if (S[h][w] == '!') continue
                for ((dh, dw) in dirs) {
                    queue.addLast(h + dh to w + dw)
                }
            }
            ans = max(ans, res)
        }
    }
    println(ans)
}
