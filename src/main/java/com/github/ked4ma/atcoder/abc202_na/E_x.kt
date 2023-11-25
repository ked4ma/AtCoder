package com.github.ked4ma.atcoder.abc202_na

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    val N = nextInt()
    val P = nextIntList()
    val Q = nextInt()
    val UD = buildList {
        repeat(Q) {
            add(nextIntList().let { (a, b) -> a to b })
        }
    }
    // generate tree
    val nodes = (1..N).map { Node(it) }
    for (i in 2..N) {
        val parent = nodes[P[i - 2] - 1]
        val child = nodes[i - 1]
        child.height = parent.height + 1
        parent.children.add(child)
    }
    // set in-out
    fun inOutDfs(node: Node, num: Int = 0): Int {
        var inOut = num
        node.`in` = inOut
        for (n in node.children.sortedBy { it.n }) {
            inOut = inOutDfs(n, inOut + 1)
        }
        node.out = inOut + 1
        return node.out
    }
    inOutDfs(nodes[0])

    val depthMap = nodes.groupBy { it.height }.mapValues { it.value.map(Node::`in`).sorted() }
    depthMap.forEach { (d, nodes) ->
        _debug_println("$d, $nodes")
    }
    for (ud in UD) {
        val u = nodes[ud.first - 1]
        val cand = depthMap.getOrDefault(ud.second, emptyList())
        println(cand.lowerBound(u.out) - cand.lowerBound(u.`in`))
    }
}

private data class Node(val n: Int, var height: Int = 0, var `in`: Int = 0, var out: Int = 0) {
    val children = mutableListOf<Node>()
}

private fun List<Int>.lowerBound(value: Int): Int {
    var bit = Integer.highestOneBit(size)
    var pos = 0

    while (bit > 0) {
        val npos = pos or bit
        if (npos <= size && this[npos - 1] < value) pos = npos
        bit = bit shr 1
    }
    return pos
}
