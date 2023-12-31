package com.github.ked4ma.atcoder.utils.models.tree.segment

import com.github.ked4ma.atcoder.utils.array.long.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.number.long.bit.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.max

// TODO consider to reflect as a product code
class SegTree private constructor(
    private val n: Long,
    private val arr: LongArray,
    private val initVal: Long,
    private val op: (a: Long, b: Long) -> Long
) {
    fun build() {
        var i = n - 1
        while (i > 0) {
            arr[i] = op(arr[i shl 1], arr[(i shl 1) or 1])
            i--
        }
    }

    fun modify(p: Long, value: Long) {
        var i = n + p
        arr[i] = value
        do {
            i = i shr 1
            arr[i] = op(arr[i shl 1], arr[(i shl 1) or 1])
        } while (i > 1)
    }

    fun query(l: Long, r: Long): Long {
        var resL = initVal
        var resR = initVal
        var i = l + n
        var j = r + n
        while (i < j) {
            if (i and 1L == 1L) resL = op(resL, arr[i++])
            if (j and 1L == 1L) resR = op(arr[--j], resR)

            i = i shr 1
            j = j shr 1
        }
        return op(resL, resR)
    }

    override fun toString(): String {
        val len = arr.maxOf { it.toString().length }
        val sb = StringBuilder()
        sb.append("${this::class.simpleName}:\n")
        sb.append("=".repeat(((len + 2) * n).toInt()))
        sb.append("\n")
        var l = 1
        var r = 1
        var ofst = n
        while (l < 2 * n) {
            for (i in l..r) {
                sb.append(" ".repeat(((ofst - 1) * (len + 2) / 2).toInt()))
                sb.append("%${len}s".format(arr[i].toString()))
                if (i < r) sb.append(", ")
                sb.append(" ".repeat(((ofst - 1) * (len + 2) / 2).toInt()))
                if (i == r) sb.append("\n")
            }
            l = l shl 1
            r = (r shl 1) or 1
            ofst = ofst shr 1
        }
        sb.append("=".repeat(((len + 2) * n).toInt()))
        return sb.toString()
    }

    companion object {
        private fun arrSize(n: Long): Long {
            var res = n.takeHighestOneBit()
            while (res < n) {
                res = res shl 1
            }
            return res
        }

        fun of(n: Long, initValue: Long, op: (a: Long, b: Long) -> Long): SegTree {
            val size = arrSize(n)
            val arr = sizedLongArray(2 * size, initValue)
            return SegTree(size, arr, initValue, op)
        }

        fun of(origin: LongArray, initValue: Long, op: (a: Long, b: Long) -> Long): SegTree {
            val size = arrSize(origin.size.toLong())
            val arr = sizedLongArray(2 * size, initValue)
            origin.forEachIndexed { index, t ->
                arr[size + index] = t
            }
            return SegTree(size, arr, initValue, op)
        }
    }
}

class SegmentTreeTest {
    @Test
    fun sample1() {
        val data = sizedLongArray(10, 0L)
        for (i in 0L until 10L) {
            data[i] = i
        }
        val segTree = SegTree.of(data, -1) { a, b -> max(a, b) }
        println(segTree)
        segTree.build()
        println(segTree)
        assertEquals(4L, segTree.query(1, 5))
        assertEquals(7L, segTree.query(6, 8))
    }
}

class LazySegTree(
    private val n: Long,
    private val arr: LongArray,
    private val d: LongArray,
    private val initVal: Long,
//    private val op: (a: Long, b: Long) -> Long
) {
    private val h = Long.SIZE_BITS - n.countLeadingZeroBits()
    private fun calc(p: Long, k: Long) {
        if (d[p] == 0L) {
            arr[p] = arr[p shl 1] + arr[(p shl 1) or 1]
        } else {
            arr[p] = d[p] * k
        }
    }

    private fun apply(p: Long, value: Long, k: Long) {
        arr[p] = value * k
        if (p < n) d[p] = value
    }

    private fun build(l: Long, r: Long) {
        var k = 2L
        var i = l + n
        var j = r + n - 1
        while (i > 1) {
            i = i shr 1
            j = j shr 1
            for (a in j downTo i) {
                calc(a, k)
            }
            k = k shl 1
        }
    }

    private fun push(l: Long, r: Long) {
        var s = h
        var k = 1L shl (h - 1)
        val ll = l + n
        val rr = r + n - 1
        while (s > 0) {
            for (i in (ll shr s)..(rr shr s)) {
                if (d[i] == 0L) continue
                apply(i shl 1, d[i], k)
                apply((i shl 1) or 1, d[i], k)
                d[i] = 0
            }
            s--
            k = k shl 1
        }
    }

    fun modify(l: Long, r: Long, value: Long) {
        if (value == 0L) return
        push(l, l + 1)
        push(r - 1, r)
        var ll = l + n
        var rr = r + n
        var k = 1L
        while (ll < rr) {
            if (ll.bit(0)) apply(ll++, value, k)
            if (rr.bit(0)) apply(--rr, value, k)

            ll = ll shr 1
            rr = rr shr 1
            k = k shl 1
            println("$ll $rr $k")
        }
        build(l, l + 1)
        build(r - 1, r)
    }

    fun query(l: Long, r: Long): Long {
        push(l, l + 1)
        push(r - 1, r)
        var res = 0L
//        var resL = initVal
//        var resR = initVal
        var i = l + n
        var j = r + n
        while (i < j) {
            if (i.bit(0)) res += arr[i++]
            if (j.bit(0)) res += arr[--j]
//            if (i.bit(0)) resL = op(resL, arr[i++])
//            if (j.bit(0)) resR = op(arr[--j], resR)
            i = i shr 1
            j = j shr 1
        }
//        return op(resL, resR)
        return res
    }

    companion object {
        private fun arrSize(n: Long): Long {
            var res = n.takeHighestOneBit()
            while (res < n) {
                res = res shl 1
            }
            return res
        }

        //        fun of(n: Long, initValue: Long, op: (a: Long, b: Long) -> Long): SegTree {
//            val size = arrSize(n)
//            val arr = sizedLongArray(2 * size, initValue)
//            return SegTree(size, arr, initValue, op)
//        }
//
        fun of(origin: LongArray, initValue: Long, op: (a: Long, b: Long) -> Long): LazySegTree {
            val size = arrSize(origin.size.toLong())
            val arr = sizedLongArray(2 * size, initValue)
            origin.forEachIndexed { index, t ->
                arr[size + index] = t
            }
            val d = sizedLongArray(size, 0L)
            return LazySegTree(size, arr, d, initValue)
        }
    }

    fun build() {
        var i = n - 1
        while (i > 0) {
            arr[i] = arr[i shl 1] + arr[(i shl 1) or 1]
            i--
        }
    }

    override fun toString(): String {
        val len = arr.maxOf { it.toString().length }
        val sb = StringBuilder()
        sb.append("${this::class.simpleName}:\n")
        sb.append("=".repeat(((len + 2) * n).toInt()))
        sb.append("\n")
        var l = 1
        var r = 1
        var ofst = n
        while (l < 2 * n) {
            for (i in l..r) {
                sb.append(" ".repeat(((ofst - 1) * (len + 2) / 2).toInt()))
                sb.append("%${len}s".format(arr[i].toString()))
                if (i < r) sb.append(", ")
                sb.append(" ".repeat(((ofst - 1) * (len + 2) / 2).toInt()))
                if (i == r) sb.append("\n")
            }
            l = l shl 1
            r = (r shl 1) or 1
            ofst = ofst shr 1
        }
        sb.append("=".repeat(((len + 2) * n).toInt()))
        return sb.toString()
    }
}