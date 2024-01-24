package com.github.ked4ma.atcoder.abc055_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*
import com.github.ked4ma.atcoder.utils.math.mod.*

fun main() {
    val mod = 1_000_000_007L
    val n = nextInt()
    var ans = 1L
    repeat(n) {
        ans = ans.times((it + 1).toLong(), mod)
    }
    println(ans)
}
