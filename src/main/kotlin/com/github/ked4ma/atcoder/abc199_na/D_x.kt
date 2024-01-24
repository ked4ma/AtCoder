package com.github.ked4ma.atcoder.abc199_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (N, M) = nextIntList()
    val connMap = (0 until M).flatMap {
        val (a, b) = nextIntList()
        listOf(
            a - 1 to b - 1,
            b - 1 to a - 1
        )
    }.groupBy(
        keySelector = Pair<Int, Int>::first,
        valueTransform = Pair<Int, Int>::second
    )
    val groups = mutableListOf<List<Int>>()
    val visited = mutableSetOf<Int>()
    fun searchGroup(i: Int, reachables: MutableList<Int> = mutableListOf()): List<Int> {
        if (i in visited) return reachables
        visited.add(i)
        reachables.add(i)
        connMap[i]?.forEach {
            searchGroup(it, reachables)
        }
        return reachables
    }
    for (i in 0 until N) {
        if (i in visited) continue
        groups.add(searchGroup(i))
    }

    val edgeColors = IntArray(N) { 0 }
    fun dfs(index: Int = 0, targets: List<Int>): Long {
        val parents = targets.subList(0, index)
        val key = targets[index]
        val colors = connMap
            .getOrDefault(key, emptyList())
            .filter { it in parents }
            .map { edgeColors[it] }
            .toSet()
        var count = 0L
        for (c in setOf(1, 2, 3) - colors) {
            edgeColors[key] = c
            count += if (index + 1 == targets.size) 1L else dfs(index + 1, targets)
            edgeColors[key] = 0
        }
        return count
    }

    var result = 1L
    for (g in groups) {
        result *= dfs(targets = g)
    }

    println(result)
}
