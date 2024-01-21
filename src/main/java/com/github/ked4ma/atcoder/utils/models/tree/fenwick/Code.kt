package com.github.ked4ma.atcoder.utils.models.tree.fenwick

import com.github.ked4ma.atcoder.utils.array.long.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.debug.*

// https://qiita.com/R_olldIce/items/f2f7930e7f67963f0493
// http://hos.ac/slides/20140319_bit.pdf
// Also Called BIT (binary indexed tree)
class FenwickTree(private val size: Long) {
    private val arr = sizedLongArray(size, 0L)

    fun add(index: Long, value: Long) {
        _debug_require(index in 0 until size) { "index must be in range [0,$this)" }
        var i = index + 1
        while (i <= size) {
            arr[i - 1] += value
            i += i and -i
        }
    }

    /**
     * sum of [0, r)
     * @param right (exclusive)
     */
    private fun sum(right: Long): Long {
        var ans = 0L
        var r = right
        while (r > 0) {
            ans += arr[r - 1]
            r -= r and -r
        }
        return ans
    }

    fun sum(left: Long, right: Long): Long {
        _debug_require(left in 0..right && right <= size) { "need: 0 <= left <= right <= $size" }
        return sum(right) - sum(left)
    }
}
