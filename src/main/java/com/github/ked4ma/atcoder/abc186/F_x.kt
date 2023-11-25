package com.github.ked4ma.atcoder.abc186

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*
import com.github.ked4ma.atcoder.utils.tree.fenwick.*
import kotlin.math.min

fun main() {
    val (h, w, m) = nextIntList()

    // →↓
    val a = sizedArray(w, h)
    // ↓→
    val b = sizedArray(h, w)
    repeat(m) {
        val (y, x) = nextIntList().let { (x, y) -> x - 1 to y - 1 }
        a[x] = min(a[x], y)
        b[y] = min(b[y], x)
    }
    var ans = 0L
    // |A|
    repeat(b[0]) {
        ans += a[it]
    }
    // |B|
    repeat(a[0]) {
        ans += b[it]
    }
    val fenwick = FenwickTree(w)
    repeat(b[0]) { x ->
        fenwick.add(x, 1)
    }
//    val segmentTree = SegmentTree.of(sizedArray(w, 0).apply {
//        repeat(b[0]) {
//            this[it] = 1
//        }
//    }.toList(), 0) { l, r ->
//        l + r
//    }
    val ends = Array(h + 1) { mutableListOf<Int>() }
    repeat(b[0]) { x ->
        ends[a[x]].add(x)
    }
    repeat(a[0]) { y ->
        ends[y].forEach { x ->
            fenwick.add(x, -1)
//            segmentTree.update(x) { 0 }
        }
        ans -= fenwick.sum(0, b[y])
//        ans -= segmentTree.get(0, b[y])
    }
    println(ans)
}
