package com.github.ked4ma.atcoder.abc185

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.tree.segment.*

fun main() {
    val (n, q) = nextIntList()
    val a = nextIntList()

    val segmentTree = SegmentTree.of(a, 0) { l, r ->
        l xor r
    }

    repeat(q) {
        val (t, x, y) = nextIntList()
        if (t == 1) {
            segmentTree.update(x - 1) {
                it xor y
            }
        } else {
            println(segmentTree.get(x - 1, y))
        }
    }
}
