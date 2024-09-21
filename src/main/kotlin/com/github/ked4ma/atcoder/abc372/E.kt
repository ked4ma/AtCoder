package com.github.ked4ma.atcoder.abc372

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.array.int.d2.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val uf = UnionFind(N)
    repeat(Q) {
        val (x, u, v) = nextIntList().map { it - 1 }
        when (x) {
            0 -> {
                uf.unite(u, v)
            }

            1 -> {
                if (uf.size(u) < v + 1) {
                    println(-1)
                } else {
                    val nodes = uf.nodes(u)
                    println(nodes[v] + 1)
                }
            }
        }
    }
}

/**
 * UnionFind
 * @param size num of elements
 * @param unionBySize enable "union-by-size" (default: true)
 */
class UnionFind(val size: Int, private val unionBySize: Boolean = true) {
    private val r = sizedIntArray(size) { -1 }

    private val nodes = sized2DIntArray(size, 10, -1)

    init {
        for (i in range(size)) {
            nodes[i][0] = i
        }
    }

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
        var i = 0
        var j = 0
        val arr = sizedIntArray(10, Int.MAX_VALUE)
        while (i + j < 10) {
            if (nodes[rx][i] > nodes[ry][j]) {
                arr[i + j] = nodes[rx][i]
                i++
            } else {
                arr[i + j] = nodes[ry][j]
                j++
            }
        }
        for (k in range(10)) {
            nodes[rx][k] = arr[k]
        }
    }

    fun size(x: Int) = -r[find(x)]
    val categories: List<Int>
        get() = r.indices.map { find(it) }

    fun same(x: Int, y: Int) = find(x) == find(y)

    fun nodes(x: Int) = nodes[find(x)]

    override fun toString(): String {
        return r.joinToString(separator = ", ")
    }
}
