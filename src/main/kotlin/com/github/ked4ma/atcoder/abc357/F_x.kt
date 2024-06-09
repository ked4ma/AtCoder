package com.github.ked4ma.atcoder.abc357

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.mod.*
import com.github.ked4ma.atcoder.utils.models.tree.segment.lazy.general.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = 998244353L
    val (N, Q) = nextIntList()

    data class X(val len: Long, val aSum: Long, val bSum: Long, val abSum: Long)
    data class M(val aAdd: Long, val bAdd: Long)

    val segTree = GeneralLazySegmentTree.instanceOf(
        n = N,
        fx = { l, r ->
            X(
                l.len + r.len,
                l.aSum.plusMod(r.aSum, MOD),
                l.bSum.plusMod(r.bSum, MOD),
                l.abSum.plusMod(r.abSum, MOD),
            )
        },
        fa = { x, m ->
            X(
                x.len,
                x.aSum.plusMod(x.len.timesMod(m.aAdd, MOD), MOD),
                x.bSum.plusMod(x.len.timesMod(m.bAdd, MOD), MOD),
                x.abSum
                    .plusMod(m.bAdd.timesMod(x.aSum, MOD), MOD)
                    .plusMod(m.aAdd.timesMod(x.bSum, MOD), MOD)
                    .plusMod(x.len.timesMod(m.aAdd, MOD).timesMod(m.bAdd, MOD), MOD),
            )
        },
        fm = { l, r -> M(l.aAdd.plusMod(r.aAdd, MOD), l.bAdd.plusMod(r.bAdd, MOD)) },
        ex = X(0, 0, 0, 0),
        em = M(0, 0)
    )

    val A = nextLongList()
    val B = nextLongList()
    repeat(N) { i ->
        segTree.set(i, X(1, A[i], B[i], A[i] * B[i]))
    }
    segTree.build()

    repeat(Q) {
        val q = nextLongList()
        when (q.first()) {
            1L -> segTree.update(q[1].toInt() - 1, q[2].toInt(), M(q[3], 0))
            2L -> segTree.update(q[1].toInt() - 1, q[2].toInt(), M(0, q[3]))
            3L -> {
                println(segTree.query(q[1].toInt() - 1, q[2].toInt()).abSum % MOD)
            }
        }
    }
}
