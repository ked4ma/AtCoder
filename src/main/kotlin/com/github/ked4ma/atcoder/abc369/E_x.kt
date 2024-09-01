package com.github.ked4ma.atcoder.abc369

import com.github.ked4ma.atcoder.utils.array.long.d2.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.abs
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val bridges = times(M) {
        val (U, V, T) = nextIntList()
        Triple(U - 1, V - 1, T.toLong())
    }
    val arr = sized2DLongArray(N, N, Long.MAX_VALUE / 2)
    for (i in range(N)) arr[i][i] = 0
    for ((U, V, T) in bridges) {
        arr[U][V] = min(arr[U][V], T)
        arr[V][U] = min(arr[V][U], T)
    }
    for (k in range(N)) {
        for (i in range(N)) {
            for (j in range(N)) {
                arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j])
            }
        }
    }

    val Q = nextInt()
    repeat(Q) {
        val K = nextInt()
        val B = nextIntList()

        var patterns = listOf(listOf<Int>())
        for (i in range(K)) {
            val next = mutableListOf<List<Int>>()
            for (p in patterns) {
                for (j in 0..i) {
                    next.add(p.toMutableList().apply { add(j, B[i]) })
                    next.add(p.toMutableList().apply { add(j, -B[i]) })
                }
            }
            patterns = next
        }
        var ans = Long.MAX_VALUE
        for (p in patterns) {
            var dist = 0L
            var cur = 0
            for (b in p) {
                val (U, V, T) = bridges[abs(b) - 1]
                if (b >= 0) {
                    dist += arr[cur][U] + T
                    cur = V
                } else {
                    dist += arr[cur][V] + T
                    cur = U
                }
            }
            dist += arr[cur][N - 1]
            ans = min(ans, dist)
        }
        println(ans)
    }
}
