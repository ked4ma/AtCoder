package com.github.ked4ma.atcoder.utils.models.tree.segment

import com.github.ked4ma.atcoder.utils.models.tree.segment.type.*
import kotlin.math.max
import kotlin.math.min

// https://algo-logic.info/segment-tree/
class SegmentTree(
    n: Int,
    private val fx: FX,
    private val fm: FX,
    private val ex: X,
) {
    private val n: Int
    private val dat: LongArray

    init {
        var x = 1
        while (x < n) {
            x *= 2
        }
        this.n = x
        this.dat = LongArray(2 * this.n + 1) { ex }
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

    fun update(i: Int, x: X) {
        var index = i + n - 1
        dat[index] = fm(dat[index], x)
        while (index > 0) {
            index = (index - 1) / 2 // parent
            dat[index] = fx(dat[index * 2 + 1], dat[index * 2 + 2])
        }
    }

    fun query(a: Int, b: Int, k: Int = 0, l: Int = 0, r: Int = n): X {
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
        fun RUQ_RMQ(size: Int) = SegmentTree(
            n = size,
            fx = { x1, x2 -> max(x1, x2) },
            fm = { _, m2 -> m2 },
            ex = Long.MIN_VALUE,
        )

        fun RUQ_RmQ(size: Int) = SegmentTree(
            n = size,
            fx = { x1, x2 -> min(x1, x2) },
            fm = { _, m2 -> m2 },
            ex = Long.MAX_VALUE,
        )

        fun RUQ_RSQ(size: Int) = SegmentTree(
            n = size,
            fx = { x1, x2 -> x1 + x2 },
            fm = { _, m2 -> m2 },
            ex = 0L,
        )

        fun RAQ_RMQ(size: Int) = SegmentTree(
            n = size,
            fx = { x1, x2 -> max(x1, x2) },
            fm = { m1, m2 -> m1 + m2 },
            ex = Long.MIN_VALUE,
        )

        fun RAQ_RmQ(size: Int) = SegmentTree(
            n = size,
            fx = { x1, x2 -> min(x1, x2) },
            fm = { m1, m2 -> m1 + m2 },
            ex = Long.MAX_VALUE,
        )

        fun RAQ_RSQ(size: Int) = SegmentTree(
            n = size,
            fx = { x1, x2 -> x1 + x2 },
            fm = { m1, m2 -> m1 + m2 },
            ex = 0L,
        )
    }
}