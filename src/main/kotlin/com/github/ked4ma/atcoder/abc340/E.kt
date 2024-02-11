package com.github.ked4ma.atcoder.abc340

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]

// ref : https://algo-logic.info/segment-tree/
typealias X = Long
typealias M = Long
typealias FX = (X, X) -> X
typealias FA = (X, M) -> X
typealias FM = (M, M) -> M

class SegTreeLazy(
    n: Int,
    private val fx: FX,
    private val fa: FA,
    private val fm: FM,
    private val ex: X,
    private val em: M
) {
    private val n: Int
    private val dat: LongArray
    private val lazy: LongArray

    init {
        var x = 1
        while (x < n) {
            x *= 2
        }
        this.n = x
        this.dat = LongArray(2 * this.n) { ex }
        this.lazy = LongArray(2 * this.n) { em }
    }

    fun set(i: Int, x: X) {
        dat[i + n - 1] = x;
    }

    fun build() {
        for (k in n - 2 downTo 0) {
            dat[k] = fx(dat[2 * k + 1], dat[2 * k + 2])
        }
    }

    private fun eval(k: Int) {
        if (lazy[k] == em) return
        if (k < n - 1) {
            lazy[k * 2 + 1] = fm(lazy[k * 2 + 1], lazy[k])
            lazy[k * 2 + 2] = fm(lazy[k * 2 + 2], lazy[k])
        }
        dat[k] = fa(dat[k], lazy[k])
        lazy[k] = em
    }

    fun update(a: Int, b: Int, x: M, k: Int = 0, l: Int = 0, r: Int = n) {
        eval(k)
        if (a <= l && r <= b) {
            lazy[k] = fm(lazy[k], x)
            eval(k)
        } else if (a < r && l < b) {
            update(a, b, x, k * 2 + 1, l, (l + r) / 2)
            update(a, b, x, k * 2 + 2, (l + r) / 2, r)
            dat[k] = fx(dat[k * 2 + 1], dat[k * 2 + 2])
        }
    }

    fun query(a: Int, b: Int, k: Int = 0, l: Int = 0, r: Int = n): X {
        eval(k)
        if (r <= a || b <= l) {
            return ex
        } else if (a <= l && r <= b) {
            return dat[k]
        } else {
            val vl = query(a, b, k * 2 + 1, l, (l + r) / 2)
            val vr = query(a, b, k * 2 + 2, (l + r) / 2, r)
            return fx(vl, vr)
        }
    }
}

// NOTE: algo is correct. but LazySegmentTree isn't much effective...
fun main() {
//    PrintWriter(System.out).use { pw ->
//        solve(pw)
//        pw.flush()
//    }
//}
//
//fun solve(pw: PrintWriter) {
    val (N, M) = nextIntList()
    val A = nextLongList()
    val B = nextIntList()

    val lazySeg = SegTreeLazy(
        n = N,
        fx = { x1, x2 -> x1 + x2 },
        fa = { x1, x2 -> x1 + x2 },
        fm = { x1, x2 -> x1 + x2 },
        ex = 0L,
        em = 0L,
    )
    repeat(N) {
        lazySeg.set(it, A[it])
    }
    lazySeg.build()
    B.forEach { b ->
        val a = lazySeg.query(b, b + 1)
        lazySeg.update(b, b + 1, -a)
        lazySeg.update(0, N, a / N)
        val rem = (a % N).toInt()
        lazySeg.update(b + 1, min(b + rem + 1, N), 1)
        if (b + rem + 1 > N) {
            lazySeg.update(0, b + rem + 1 - N, 1)
        }
    }
// //    val lazySeg = LazySegmentTree.of(A.toLongArray(), Updater.RAQ, Evaluator.RmQ)
// //    B.forEach { b ->
// //        val a = lazySeg.query(b, b + 1)
// //        lazySeg.update(b, b + 1, -a)
// //        lazySeg.update(0, N, a / N)
// //        val rem = (a % N).toInt()
// //        lazySeg.update(b + 1, min(b + rem + 1, N), 1)
// //        if (b + rem + 1 > N) {
// //            lazySeg.update(0, b + rem + 1 - N, 1)
// //        }
// //    }

    val sb = StringBuilder()
    for (i in 0 until N) {
        if (i > 0) sb.append(' ')
        sb.append(lazySeg.query(i, i + 1))
    }
    println(sb)
//    for (i in 0 until N) {
//        if (i > 0) pw.print(' ')
//        pw.print(lazySeg.query(i, i + 1))
//    }
}