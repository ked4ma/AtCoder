package com.github.ked4ma.atcoder.utils.models.unionfind

import com.github.ked4ma.atcoder.utils.array.int.d1.*

/**
 * UnionFind
 * @param size num of elements
 * @param unionBySize enable "union-by-size" (default: true)
 */
class UnionFind(val size: Int, private val unionBySize: Boolean = true) {
    private val r = sizedIntArray(size) { -1 }

    // find root
    fun find(x: Int): Int {
        if (r[x] < 0) return x
        // route compression
        val comp = mutableListOf<Int>()
        var i = x
        while (r[i] >= 0) {
            comp.add(i)
            i = r[i]
        }
        for (j in comp) {
            r[j] = i
        }
        return i
    }

    val roots: List<Int>
        get() = (r.indices).map { find(it) }

    fun unite(x: Int, y: Int) {
        var rx = find(x)
        var ry = find(y)
        if (rx == ry) return
        if (unionBySize && r[rx] > r[ry]) {
            rx = ry.also { ry = rx }
        }
        r[rx] += r[ry]
        r[ry] = rx
    }

    fun size(x: Int) = -r[find(x)]
    val categories: List<Int>
        get() = r.indices.map { find(it) }

    fun same(x: Int, y: Int) = find(x) == find(y)

    override fun toString(): String {
        return r.joinToString(separator = ", ")
    }
}
