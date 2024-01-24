package com.github.ked4ma.atcoder.utils.models.tree.segment

import com.github.ked4ma.atcoder.utils.array.long.d1.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.max

class SegmentTreeTest {
    @Test
    fun sample1() {
        val data = sizedLongArray(10, 0L)
        for (i in 0 until 10) {
            data[i] = i.toLong()
        }
        val segTree = SegmentTree.of(data.toList(), -1) { a, b -> max(a, b) }
        assertEquals(4L, segTree.get(1, 5))
        assertEquals(7L, segTree.get(6, 8))
    }
}