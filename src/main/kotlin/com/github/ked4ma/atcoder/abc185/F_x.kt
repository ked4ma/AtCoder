package com.github.ked4ma.atcoder.abc185

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.tree.segment.*

fun main() {
    val (n, q) = nextIntList()
    val a = nextLongList()

    val segmentTree = SegmentTree(
        n = a.size,
        fx = { x1, x2 -> x1 xor x2},
        fm = { x1, x2 -> x1 xor x2},
        ex= 0,
    )
    segmentTree.init(a)

    repeat(q) {
        val (t, x, y) = nextIntList()
        if (t == 1) {
            segmentTree.update(x - 1, y.toLong())
        } else {
            println(segmentTree.query(x - 1, y))
        }
    }
}
