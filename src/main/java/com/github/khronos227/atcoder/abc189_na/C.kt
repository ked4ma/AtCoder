package com.github.khronos227.atcoder.abc189_na

import com.github.khronos227.atcoder.utils.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    val N = nextInt()
    val A = nextLongList()

    var ans = 0L
    for (l in 0 until N) {
        var x = A[l]
        for (r in l until N) {
            x = min(x, A[r])
            ans = max(ans, x * (r - l + 1))
        }
    }
    println(ans)
}
