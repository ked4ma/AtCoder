package com.github.ked4ma.atcoder.abc355

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.mod.*
import com.github.ked4ma.atcoder.utils.number.int.bit.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, L, R) = nextIntList()
    val MAX = 1 shl N
    val G = sizedArray(MAX + 1) { mutableListOf<Int>() }
    for (i in range(N + 1)) {
        for (l in 0 until MAX step (1 shl i)) {
            val r = l + (1 shl i)
            G[l].add(r)
            G[r].add(l)
        }
    }

    val parent = sizedIntArray(MAX + 1, -2)
    parent[R + 1] = -1
    val queue = ArrayDeque(listOf(R + 1))
    while (queue.isNotEmpty()) {
        val u = queue.removeFirst()
        for (v in G[u]) {
            if (parent[v] == -2) {
                parent[v] = u
                queue.addLast(v)
            }
        }
    }

    var ans = 0L
    var cur = L
    while (parent[cur] != -1) {
        val p = parent[cur]
        var sgn = 1
        var (l, r) = cur to p
        if (l > r) {
            sgn = -1
            val tmp = l
            l = r
            r = tmp
        }
        val i = (r - l).bitLength() - 1
        val j = l shr i
        println("? $i $j")
        val v = nextLong()
        if (sgn == 1) {
            ans = ans.plusMod(v, 100)
        } else {
            ans = ans.minusMod(v, 100)
        }
        cur = p
    }
    println("! $ans")
}
