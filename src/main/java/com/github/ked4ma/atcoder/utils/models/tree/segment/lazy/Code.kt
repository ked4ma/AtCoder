package com.github.ked4ma.atcoder.utils.models.tree.segment.lazy

import com.github.ked4ma.atcoder.utils.array.any.*
import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.long.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.number.long.bit.*
import kotlin.math.max
import kotlin.math.min

// ref: https://smijake3.hatenablog.com/entry/2018/11/03/100133#%E3%82%B3%E3%83%BC%E3%83%89%E5%AE%9F%E8%A3%85-RMQ-and-RAQ
//      https://tsutaj.hatenablog.com/entry/2017/03/30/224339
//      https://codeforces.com/blog/entry/18051 (Concept)
class LazySegmentTree(
    private val n: Long,
    private val data: LongArray,
    private val lazy: Array<Long?>,
    private val updater: Updater,
    private val evaluator: Evaluator,
) {
    private fun genPropagatedIndices(l: Long, r: Long): List<Long> {
        var ll = l + n
        var rr = r + n
        // first number that right shifted all "tailing ZEROs"
        // e.g. 0x110100 -> 0x1101
        val lm = (ll / (ll and -ll)) shr 1
        val rm = (rr / (rr and -rr)) shr 1
        return buildList {
            while (ll < rr) {
                if (rr <= rm) add(rr)
                if (ll <= lm) add(ll)
                rr = rr shr 1
                ll = ll shr 1
            }
            while (ll > 0) {
                add(ll)
                ll = ll shr 1
            }
        }
    }

    private fun propagate(ids: List<Long>) {
        for (i in ids.asReversed()) {
            val v = lazy[i]?.let { it shr evaluator.propShift } ?: continue
            lazy[2 * i] = updater.action(lazy[2 * i] ?: 0L, v)
            data[2 * i] = updater.action(data[2 * i], v)
            lazy[2 * i + 1] = updater.action(lazy[2 * i + 1] ?: 0L, v)
            data[2 * i + 1] = updater.action(data[2 * i + 1], v)
            lazy[i] = null
        }
    }

    fun update(l: Long, r: Long, x: Long) {
        val ids = genPropagatedIndices(l, r)
        propagate(ids)

        var ll = l + n
        var rr = r + n
        var xx = x
        while (ll < rr) {
            if (rr.bit(0)) {
                --rr
                lazy[rr] = updater.action(lazy[rr], xx)
                data[rr] = updater.action(data[rr], xx)
            }
            if (ll.bit(0)) {
                lazy[ll] = updater.action(lazy[ll], xx)
                data[ll] = updater.action(data[ll], xx)
                ll++
            }
            ll = ll shr 1
            rr = rr shr 1
            xx = xx shl evaluator.propShift
        }

        for (i in ids) {
            data[i] = evaluator.action(data[2 * i], data[2 * i + 1])
        }
    }

    fun query(l: Long, r: Long): Long {
        propagate(genPropagatedIndices(l, r))

        var ll = l + n
        var rr = r + n

        var res = evaluator.init
        while (ll < rr) {
            if (rr.bit(0)) res = evaluator.action(res, data[--rr])
            if (ll.bit(0)) res = evaluator.action(res, data[ll++])
            ll = ll shr 1
            rr = rr shr 1
        }
        return res
    }

    fun build() {
        var i = n - 1
        while (i > 0) {
            data[i] = evaluator.action(data[i shl 1], data[(i shl 1) or 1])
            i--
        }
    }

    // TODO brush-up
    override fun toString(): String {
        val len = data.maxOf { it.toString().length }
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
                sb.append("%${len}s".format(data[i].toString()))
                // if (i < n) sb.append("/${lazy[i]}")
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

        fun of(
            origin: LongArray,
            updater: Updater,
            evaluator: Evaluator,
        ): LazySegmentTree {
            val size = arrSize(origin.size.toLong())
            val arr = sizedLongArray(2 * size, 0L)
            origin.forEachIndexed { index, t ->
                arr[size + index] = t
            }
            val d = sizedArray<Long?>(2 * size, null)
            return LazySegmentTree(
                size,
                arr,
                d,
                updater,
                evaluator,
            )
        }
    }
}

enum class Updater(
    val action: (Long?, Long) -> Long,
) {
    RUQ({ _, b -> b }),
    RAQ({ a, b -> (a ?: 0L) + b }),
}

enum class Evaluator(
    val action: (Long, Long) -> Long,
    val propShift: Long,
    val init: Long,
) {
    RmQ(::min, 0L, Long.MAX_VALUE),
    RMQ(::max, 0L, Long.MIN_VALUE),
    RSQ({ a, b -> a + b }, 1L, 0L)
}

