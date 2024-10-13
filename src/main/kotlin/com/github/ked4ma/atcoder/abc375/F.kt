package com.github.ked4ma.atcoder.abc375

import com.github.ked4ma.atcoder.utils.array.long.d2.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, Q) = nextIntList()
    val roads = times(M) {
        val (A, B, C) = nextIntList()
        Triple(A, B, C.toLong())
    }
    val queries = times(Q) {
        nextIntList()
    }
    val G = sized2DLongArray(N, N, Long.MAX_VALUE / 2)
    val blocks = queries.filter { it[0] == 1 }.map { it[1] - 1 }.toSet()
    roads.filterIndexed { i, _ -> i !in blocks }.forEach { (A, B, C) ->
        G[A - 1][B - 1] = C
        G[B - 1][A - 1] = C
    }
    for (k in range(N)) {
        for (i in range(N)) {
            for (j in range(N)) {
                G[i][j] = min(G[i][j], G[i][k] + G[k][j])
            }
        }
    }
    val ans = mutableListOf<Long>()
    queries.asReversed().forEach { q ->
        when (q[0]) {
            1 -> {
                val (A, B, C) = roads[q[1] - 1]
                G[A - 1][B - 1] = min(G[A - 1][B - 1], C)
                G[B - 1][A - 1] = min(G[B - 1][A - 1], C)
                for (k in listOf(A - 1, B - 1)) {
                    for (i in range(N)) {
                        for (j in range(N)) {
                            G[i][j] = min(G[i][j], G[i][k] + G[k][j])
                        }
                    }
                }
            }

            2 -> {
                val x = q[1] - 1
                val y = q[2] - 1
                ans.add(if (G[x][y] == Long.MAX_VALUE / 2) -1 else G[x][y])
            }
        }
    }
    println(ans.asReversed().joinToString("\n"))
}
