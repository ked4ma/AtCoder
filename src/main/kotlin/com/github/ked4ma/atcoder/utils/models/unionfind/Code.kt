package com.github.ked4ma.atcoder.utils.models.unionfind

import com.github.ked4ma.atcoder.utils.array.int.d1.*

class UnionFind(val size: Int) {
    private val r = sizedIntArray(size) { -1 }
    fun root(x: Int): Int {
        if (r[x] < 0) return x
        return root(r[x])
    }

    val roots: List<Int>
        get() = (r.indices).map { root(it) }

    fun unite(x: Int, y: Int) {
        var rx = root(x)
        var ry = root(y)
        if (rx == ry) return
        if (r[rx] > r[ry]) {
            rx = ry.also { ry = rx }
        }
        r[rx] += r[ry]
        r[ry] = rx
    }

    fun size(x: Int) = -r[root(x)]
    val categories: List<Int>
        get() = r.indices.map { root(it) }

    fun same(x: Int, y: Int) = root(x) == root(y)

    override fun toString(): String {
        return r.joinToString(separator = ", ")
    }
}
