package com.github.ked4ma.atcoder.utils.models.tree.lca

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.array.int.d2.*
import com.github.ked4ma.atcoder.utils.number.int.bit.*
import com.github.ked4ma.atcoder.utils.repeat.*
import java.util.*
import kotlin.math.log2

// LCA (lowest common ancestor)
// @param N size of tree
class LCATree(private val N: Int) {
    private val G = sizedArray(N) { mutableListOf<Int>() }
    private val height = (log2(N.toDouble()) + 1).toInt()
    private val parent = sized2DIntArray(height, N, -1)
    private val depth = sizedIntArray(N, 0)

    fun addEdge(a: Int, b: Int) {
        G[a].add(b)
        G[b].add(a)
    }

    fun build(root: Int = 0) {
        val stack = Stack<Int>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val cur = stack.pop()
            for (next in G[cur]) {
                if (parent[0][cur] != next && parent[0][next] != cur) {
                    parent[0][next] = cur
                    depth[next] = depth[cur] + 1
                    stack.push(next)
                }
            }
        }
        for (k in 1 until height) {
            for (i in range(N)) {
                if (parent[k - 1][i] == -1) {
                    parent[k][i] = -1
                } else {
                    parent[k][i] = parent[k - 1][parent[k - 1][i]]
                }
            }
        }
    }

    fun lca(a: Int, b: Int): Int {
        var (x, y) = if (depth[a] > depth[b]) b to a else a to b
        // fit depth between "a" and "b"
        for (k in height - 1 downTo 0) {
            if ((depth[y] - depth[x]).bit(k)) {
                y = parent[k][y]
            }
        }
        if (x == y) return x
        // search parents until find common ancestor
        for (k in height - 1 downTo 0) {
            if (parent[k][x] != parent[k][y]) {
                x = parent[k][x]
                y = parent[k][y]
            }
        }
        return parent[0][x]
    }

    fun distance(a: Int, b: Int): Int {
        return depth[a] + depth[b] - 2 * depth[lca(a, b)]
    }
}