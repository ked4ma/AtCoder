package com.github.ked4ma.atcoder.utils.tree.fenwick

// https://qiita.com/R_olldIce/items/f2f7930e7f67963f0493
// http://hos.ac/slides/20140319_bit.pdf
// Also Called BIT (binary indexed tree)
class FenwickTree(private val size: Int) {
    private val arr = Array(size) { 0L }

    fun add(index: Int, value: Long) {
        if (index !in 0 until size) throw IllegalArgumentException("index must be in range [0,$this)")
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
    private fun sum(right: Int): Long {
        var ans = 0L
        var r = right
        while (r > 0) {
            ans += arr[r - 1]
            r -= r and -r
        }
        return ans
    }

    fun sum(left: Int, right: Int): Long {
        if (left < 0 || size < right || right < left) {
            throw IllegalArgumentException("need: 0 <= left <= right <= $size")
        }
        return sum(right) - sum(left)
    }
}
