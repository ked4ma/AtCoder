package com.github.ked4ma.atcoder.utils.models.unionfind

import com.github.ked4ma.atcoder.utils.array.long.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*

class UnionFind(val size: Long) {
    private val r = sizedLongArray(size) { -1L }
    fun root(x: Long): Long {
        if (r[x] < 0) return x
        return root(r[x])
    }

    val roots: List<Long>
        get() = (r.indices).map { root(it.toLong()) }

    fun unite(x: Long, y: Long) {
        var rx = root(x)
        var ry = root(y)
        if (rx == ry) return
        if (r[rx] > r[ry]) {
            rx = ry.also { ry = rx }
        }
        r[rx] += r[ry]
        r[ry] = rx
    }

    fun size(x: Long) = -r[root(x)]
    val categories: List<Long>
        get() = r.indices.map { root(it.toLong()) }

    override fun toString(): String {
        return r.joinToString(separator = ", ")
    }
}
