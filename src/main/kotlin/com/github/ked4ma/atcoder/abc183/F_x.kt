package com.github.ked4ma.atcoder.abc183

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.unionfind.*

fun main() {
    val (n, q) = nextIntList()
    val c = listOf(-1) + nextIntList()

    val uf = UnionFind(n + 1)
    val m = mutableMapOf<Int, MutableMap<Int, Int>>()
    repeat(q) {
        val (k, a, b) = nextIntList()
        when (k) {
            1 -> {
                val ra = uf.root(a)
                val rb = uf.root(b)
                if (ra == rb) return@repeat
                val aMap = m.getOrDefault(ra, mutableMapOf(c[ra] to 1))
                val bMap = m.getOrDefault(rb, mutableMapOf(c[rb] to 1))
                uf.unite(a, b)
                m.remove(a)
                m.remove(b)
                val (from, to) = if (aMap.size <= bMap.size) {
                    aMap to bMap
                } else {
                    bMap to aMap
                }
                from.forEach { (k, v) ->
                    to[k] = to.getOrDefault(k, 0) + v
                }
                m[uf.root(a)] = to
            }

            2 -> {
                val ra = uf.root(a)
                println(m.getOrDefault(ra, mutableMapOf(c[ra] to 1)).getOrDefault(b, 0))
            }
        }
    }
}
