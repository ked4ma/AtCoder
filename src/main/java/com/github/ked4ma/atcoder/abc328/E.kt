package com.github.ked4ma.atcoder.abc328

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextLongList().let { (N, M, K) ->
        Triple(N.toInt(), M.toInt(), K)
    }
    val map = sized2DArray(N, N, Long.MAX_VALUE)
    repeat(M) {
        val (u, v, w) = nextLongList().let { (u, v, w) ->
            Triple(u.toInt() - 1, v.toInt() - 1, w)
        }
        map[u][v] = w
        map[v][u] = w
    }

    fun calc(): Long {
        var u = 0
        var minv = 0L
        val d = sizedArray(N, Long.MAX_VALUE)
        val p = sizedArray(N, -1)
        val color = sizedArray(N, 0)

        d[0] = 0

        while (true) {
            minv = Long.MAX_VALUE
            u = -1
            for (i in 0 until N) {
                if (minv > d[i] && color[i] != 2) {
                    u = i
                    minv = d[i]
                }
            }
            if (u == -1) break
            color[u] = 2
            for (v in 0 until N) {
                if (color[v] != 2 && map[u][v] != Long.MAX_VALUE) {
                    if (d[v] > map[u][v]) {
                        d[v] = map[u][v]
                        p[v] = u
                        color[v] = 1
                    }
                }
            }
        }
        var sum = 0L
        for (i in 0 until N) {
            if (p[i] != -1) {
                sum += map[i][p[i]]
                _debug_println("$i ${p[i]}")
            }
        }
        return sum
    }
    println(calc() % K)
}