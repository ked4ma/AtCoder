package com.github.ked4ma.atcoder.abc049_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.unionfind.*

fun main() {
    val (n, k, l) = nextIntList()
    val ufRoad = UnionFind(n)
    repeat(k) {
        val (a, b) = nextIntList()
        ufRoad.unite(a - 1, b - 1)
    }
    val ufTrain = UnionFind(n)
    repeat(l) {
        val (a, b) = nextIntList()
        ufTrain.unite(a - 1, b - 1)
    }
    val z = ufRoad.roots.zip(ufTrain.roots)
    val g = z.groupingBy { it }.eachCount()
    println(z.map { g[it] }.joinToString(separator = " "))
}
