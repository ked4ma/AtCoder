package com.github.ked4ma.atcoder.abc332

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.*
import com.github.ked4ma.atcoder.utils.list.default.*
import com.github.ked4ma.atcoder.utils.loop.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextLongList()
    val A = times(H) {
        nextLongList()
    }
    val B = times(H) {
        nextLongList()
    }

    val P = (0 until H).toList()
    val permP = P.permutations(H.toInt())
    val Q = (0 until W).toList()
    val permQ = Q.permutations(W.toInt())

    fun bbl(list: List<Long>): Long {
        val arr = list.toLongArray()
        var count = 0L
        for (i in 0 until arr.lastIndex) {
            for (j in i + 1 until arr.size) {
                if (arr[i] > arr[j]) {
                    val tmp = arr[i]
                    arr[i] = arr[j]
                    arr[j] = tmp
                    count++
                }
            }
        }
        return count
    }

    var ans = Long.MAX_VALUE
    permP.forEach { p ->
        permQ.forEach { q ->
            val match = (0 until H).all { h ->
                (0 until W).all { w ->
                    A[p[h]][q[w]] == B[h][w]
                }
            }
            if (match) {
                ans = min(ans, bbl(p) + bbl(q))
            }
        }
    }
    println(if (ans == Long.MAX_VALUE) -1 else ans)
}