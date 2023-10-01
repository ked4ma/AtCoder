package com.github.ked4ma.atcoder.abc196_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (H, W, A, B) = nextIntList()

    var ans = 0

    /**
     * bit: used as used cell mapping data.
     */
    fun dfs(i: Int, bit: Int, a: Int, b: Int) {
        if (i == H * W) {
            ans++
            return
        }
        if (bit and (1 shl i) > 0) dfs(i + 1, bit, a, b)
        if (b > 0) dfs(i + 1, bit or (1 shl i), a, b - 1) // use 1 cell
        if (a > 0) { // use 2 cells
            if (i % W != W - 1 && bit and (1 shl (i + 1)) == 0) { // landscape
                dfs(i + 1, bit or (1 shl i) or (1 shl (i + 1)), a - 1, b)
            }
            if (i + W < W * H) { // portrait
                dfs(i + 1, bit or (1 shl i) or (1 shl (i + W)), a - 1, b)
            }
        }
    }

    dfs(0, 0, A, B)
    println(ans)
}
