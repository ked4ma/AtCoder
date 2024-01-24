package com.github.ked4ma.atcoder.abc177_na

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.max

fun main() {
    val (n, m) = nextIntList()
    val uf = UnionFindTree(n)

    repeat(m) {
        val (a, b) = nextIntList()
        uf.unite(a - 1, b - 1)
    }

    var MAX = 0
    (0 until n).forEach {
        MAX = max(MAX, uf.size(it))
    }

    println(MAX)
}

class UnionFindTree(val size: Int) {
    private val r = sizedArray(size, -1)
    fun root(x: Int): Int {
        if (r[x] < 0) return x
        return root(r[x])
    }

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

    override fun toString(): String {
        return r.joinToString(separator = ", ")
    }
}
