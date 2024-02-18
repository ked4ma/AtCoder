package com.github.ked4ma.atcoder.utils.models.tree.segment

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SegmentTreeTest {
    private val n = 16L
    private val data = (1..n).toList()

    @Test
    fun test_RUQ_RMQ() { // update + max(query)
        val segTree = SegmentTree.RUQ_RMQ(data.size)
        segTree.init(data)

        assertEquals(5L, segTree.query(1, 5))
        assertEquals(8L, segTree.query(6, 8))
        assertEquals(7L, segTree.query(0, 7))
        segTree.update(6, 10)
        assertEquals(10, segTree.query(6, 7))
        assertEquals(6, segTree.query(0, 6))
        assertEquals(10, segTree.query(1, 7))
        segTree.update(3, 20)
        assertEquals(20, segTree.query(3, 4))
        assertEquals(20, segTree.query(0, 6))
        assertEquals(20, segTree.query(0, 4))
        assertEquals(3, segTree.query(0, 3))
        assertEquals(5, segTree.query(4, 5))

        assertEquals(Long.MIN_VALUE, segTree.query(7, 7))
    }

    @Test
    fun test_RUQ_RmQ() { // update + min(query)
        val segTree = SegmentTree.RUQ_RmQ(data.size)
        segTree.init(data)

        assertEquals(2L, segTree.query(1, 5))
        assertEquals(7L, segTree.query(6, 8))
        assertEquals(1L, segTree.query(0, 7))
        segTree.update(4, 10)
        assertEquals(10, segTree.query(4, 5))
        assertEquals(6, segTree.query(4, 7))
        assertEquals(3, segTree.query(2, 7))

        assertEquals(Long.MAX_VALUE, segTree.query(6, 6))
    }

    @Test
    fun test_RUQ_RSQ() { // update + sum(query)
        val segTree = SegmentTree.RUQ_RSQ(data.size)
        segTree.init(data)

        assertEquals(14L, segTree.query(1, 5))
        assertEquals(15L, segTree.query(6, 8))
        assertEquals(28L, segTree.query(0, 7))
        segTree.update(3, 10)
        assertEquals(1L, segTree.query(0, 1))
        assertEquals(2L, segTree.query(1, 2))
        assertEquals(3L, segTree.query(2, 3))
        assertEquals(10L, segTree.query(3, 4))
        assertEquals(5L, segTree.query(4, 5))
        assertEquals(6L, segTree.query(5, 6))
        assertEquals(7L, segTree.query(6, 7))
        assertEquals(8L, segTree.query(7, 8))
        assertEquals(9L, segTree.query(8, 9))
        assertEquals(51L, segTree.query(0, 9))
        assertEquals(72L, segTree.query(0, 11))

        assertEquals(0L, segTree.query(5, 5))
    }


    @Test
    fun test_RAQ_RMQ() { // add + max(query)
        val segTree = SegmentTree.RAQ_RMQ(data.size)
        segTree.init(data)

        assertEquals(5L, segTree.query(1, 5))
        assertEquals(8L, segTree.query(6, 8))
        assertEquals(7L, segTree.query(0, 7))
        segTree.update(4, 10)
        assertEquals(1L, segTree.query(0, 1))
        assertEquals(15L, segTree.query(1, 5))

        assertEquals(15L, segTree.query(0, 9))
        assertEquals(15L, segTree.query(0, 11))
        assertEquals(8, segTree.query(7, 8))
        segTree.update(3, 10)
        segTree.update(5, 10)
        assertEquals(1, segTree.query(0, 1))
        assertEquals(2, segTree.query(1, 2))
        assertEquals(3, segTree.query(2, 3))
        assertEquals(14, segTree.query(3, 4))
        assertEquals(15, segTree.query(4, 5))
        assertEquals(16, segTree.query(5, 6))
        assertEquals(7, segTree.query(6, 7))
        assertEquals(8, segTree.query(7, 8))
    }

    @Test
    fun test_RAQ_RmQ() {
        val segTree = SegmentTree.RAQ_RmQ(data.size)
        segTree.init(data)

        assertEquals(2L, segTree.query(1, 5))
        assertEquals(7L, segTree.query(6, 8))
        assertEquals(1L, segTree.query(0, 7))
        segTree.update(3, 10)
        assertEquals(1L, segTree.query(0, 1))
        assertEquals(2L, segTree.query(1, 2))
        assertEquals(5L, segTree.query(3, 9))
        assertEquals(1L, segTree.query(0, 11))
        assertEquals(8L, segTree.query(7, 8))
        segTree.update(4, 10)
        assertEquals(1L, segTree.query(0, 1))
        assertEquals(2L, segTree.query(1, 2))
        assertEquals(3L, segTree.query(2, 3))
        assertEquals(14L, segTree.query(3, 4))
        assertEquals(15L, segTree.query(4, 5))
        assertEquals(6L, segTree.query(5, 6))
        assertEquals(7L, segTree.query(6, 7))
        assertEquals(8L, segTree.query(7, 8))
        assertEquals(6L, segTree.query(3, 8))
    }

    @Test
    fun test_RAQ_RSQ() { // add + sum(query)
        val segTree = SegmentTree.RAQ_RSQ(data.size)
        segTree.init(data)

        assertEquals(14L, segTree.query(1, 5))
        assertEquals(15L, segTree.query(6, 8))
        assertEquals(28L, segTree.query(0, 7))
        segTree.update(5, 10)
        assertEquals(1L, segTree.query(0, 1))
        assertEquals(2L, segTree.query(1, 2))
        assertEquals(3L, segTree.query(2, 3))
        assertEquals(4L, segTree.query(3, 4))
        assertEquals(5L, segTree.query(4, 5))
        assertEquals(16L, segTree.query(5, 6))
        assertEquals(7L, segTree.query(6, 7))
        assertEquals(8L, segTree.query(7, 8))
        assertEquals(9L, segTree.query(8, 9))
        assertEquals(55L, segTree.query(0, 9))
        assertEquals(76L, segTree.query(0, 11))
        assertEquals(8L, segTree.query(7, 8))
        segTree.update(7, 10)
        assertEquals(1L, segTree.query(0, 1))
        assertEquals(2L, segTree.query(1, 2))
        assertEquals(3L, segTree.query(2, 3))
        assertEquals(4L, segTree.query(3, 4))
        assertEquals(5L, segTree.query(4, 5))
        assertEquals(16L, segTree.query(5, 6))
        assertEquals(7L, segTree.query(6, 7))
        assertEquals(18, segTree.query(7, 8))
        assertEquals(41L, segTree.query(5, 8))
    }
}