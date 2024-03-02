package com.github.ked4ma.atcoder.utils.models.tree.segment.general

class GeneralSegmentTree<T>(
    private val n: Int,
    private val dat: Array<T>,
    private val fx: (T, T) -> T,
    private val fm: (T, T) -> T,
    private val ex: T,
) {
    fun set(i: Int, x: T) {
        dat[i + n - 1] = x
    }

    fun build() {
        for (k in n - 2 downTo 0) {
            dat[k] = fx(dat[2 * k + 1], dat[2 * k + 2])
        }
    }

    fun init(data: Iterable<T>) {
        data.forEachIndexed { i, x ->
            set(i, x)
        }
        build()
    }

    fun update(i: Int, x: T) {
        var index = i + n - 1
        dat[index] = fm(dat[index], x)
        while (index > 0) {
            index = (index - 1) / 2 // parent
            dat[index] = fx(dat[index * 2 + 1], dat[index * 2 + 2])
        }
    }

    fun query(a: Int, b: Int, k: Int = 0, l: Int = 0, r: Int = n): T {
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
        inline fun <reified T> getInstance(
            n: Int,
            noinline fx: (T, T) -> T,
            noinline fm: (T, T) -> T,
            ex: T,
        ): GeneralSegmentTree<T> {
            var x = 1
            while (x < n) {
                x *= 2
            }
            val dat = Array(2 * x + 1) { ex }
            return GeneralSegmentTree(
                n = x,
                dat = dat,
                fx = fx,
                fm = fm,
                ex = ex,
            )
        }
    }
}
