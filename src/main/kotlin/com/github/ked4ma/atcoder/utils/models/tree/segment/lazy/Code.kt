package com.github.ked4ma.atcoder.utils.models.tree.segment.lazy

import com.github.ked4ma.atcoder.utils.models.tree.segment.type.*
import kotlin.math.max
import kotlin.math.min

// ref : https://algo-logic.info/segment-tree/
class LazySegmentTree(
    n: Int,
    private val fx: FX,
    private val fa: FA,
    private val fm: FM,
    private val fp: FP = { m, i -> m },
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

    fun init(data: Iterable<Long>) {
        data.forEachIndexed { i, x ->
            set(i, x)
        }
        build()
    }

    fun init(data: LongArray) {
        data.forEachIndexed { i, x ->
            set(i, x)
        }
        build()
    }

    private fun eval(k: Int, len: Int) {
        if (lazy[k] == em) return
        if (k < n - 1) {
            lazy[k * 2 + 1] = fm(lazy[k * 2 + 1], lazy[k])
            lazy[k * 2 + 2] = fm(lazy[k * 2 + 2], lazy[k])
        }
        dat[k] = fa(dat[k], fp(lazy[k], len))
        lazy[k] = em
    }

    fun update(a: Int, b: Int, x: M, k: Int = 0, l: Int = 0, r: Int = n) {
        eval(k, r - l)
        if (a <= l && r <= b) {
            lazy[k] = fm(lazy[k], x)
            eval(k, r - l)
        } else if (a < r && l < b) {
            update(a, b, x, k * 2 + 1, l, (l + r) / 2)
            update(a, b, x, k * 2 + 2, (l + r) / 2, r)
            dat[k] = fx(dat[k * 2 + 1], dat[k * 2 + 2])
        }
    }

    fun query(a: Int, b: Int, k: Int = 0, l: Int = 0, r: Int = n): X {
        eval(k, r - l)
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

    companion object {
        fun RUQ_RMQ(size: Int) = LazySegmentTree(
            n = size,
            fx = { x1, x2 -> max(x1, x2) },
            fa = { _, m -> m },
            fm = { _, m2 -> m2 },
            ex = Long.MIN_VALUE,
            em = Long.MIN_VALUE,
        )

        fun RUQ_RmQ(size: Int) = LazySegmentTree(
            n = size,
            fx = { x1, x2 -> min(x1, x2) },
            fa = { _, m -> m },
            fm = { _, m2 -> m2 },
            ex = Long.MAX_VALUE,
            em = Long.MAX_VALUE,
        )

        fun RUQ_RSQ(size: Int) = LazySegmentTree(
            n = size,
            fx = { x1, x2 -> x1 + x2 },
            fa = { _, m -> m },
            fm = { _, m2 -> m2 },
            fp = { m, i -> m * i },
            ex = 0L,
            em = 0L,
        )

        fun RAQ_RMQ(size: Int) = LazySegmentTree(
            n = size,
            fx = { x1, x2 -> max(x1, x2) },
            fa = { x, m -> x + m },
            fm = { m1, m2 -> m1 + m2 },
            ex = Long.MIN_VALUE,
            em = 0L,
        )

        fun RAQ_RmQ(size: Int) = LazySegmentTree(
            n = size,
            fx = { x1, x2 -> min(x1, x2) },
            fa = { x, m -> x + m },
            fm = { m1, m2 -> m1 + m2 },
            ex = Long.MAX_VALUE,
            em = 0L,
        )

        fun RAQ_RSQ(size: Int) = LazySegmentTree(
            n = size,
            fx = { x1, x2 -> x1 + x2 },
            fa = { x, m -> x + m },
            fm = { m1, m2 -> m1 + m2 },
            fp = { m, i -> m * i },
            ex = 0L,
            em = 0L,
        )
    }
}