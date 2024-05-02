package com.github.ked4ma.atcoder.utils.models.tree.segment.lazy.general2

import com.github.ked4ma.atcoder.utils.array.wrap.*
import com.github.ked4ma.atcoder.utils.array.wrap.d1.*

// [CAUTION] NOT recommended to use Pair.
//           Consider to use data class instead.
// THIS is EXPERIMENTAL class
class GeneralLazySegmentTree2<X, M>(
    private val n: Int,
    private val dat: WrappedArray<X>,
    private val lazy: WrappedArray<M>,
    private val fx: (X, X) -> X,
    private val fa: (X, M) -> X,
    private val fm: (M, M) -> M,
    private val fp: (M, Int) -> M = { m, _ -> m },
    private val ex: X,
    private val em: M
) {
    fun set(i: Int, x: X) {
        dat[i + n - 1] = x
    }

    fun build() {
        for (k in n - 2 downTo 0) {
            dat[k] = fx(dat[2 * k + 1], dat[2 * k + 2])
        }
    }

    fun init(data: Iterable<X>) {
        data.forEachIndexed { i, x ->
            set(i, x)
        }
        build()
    }

    fun init(data: Array<X>) {
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
        inline fun <reified X, reified M> instanceOf(
            n: Int,
            noinline fx: (X, X) -> X,
            noinline fa: (X, M) -> X,
            noinline fm: (M, M) -> M,
            noinline fp: (M, Int) -> M = { m, _ -> m },
            ex: X,
            em: M
        ): GeneralLazySegmentTree2<X, M> {
            var x = 1
            while (x < n) {
                x *= 2
            }
            val dat = sizedWrappedArray(2 * x, ex)
            val lazy = sizedWrappedArray(2 * x, em)
            return GeneralLazySegmentTree2(
                x,
                dat,
                lazy,
                fx,
                fa,
                fm,
                fp,
                ex,
                em
            )
        }
    }
}