package com.github.ked4ma.atcoder.abc374

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.number.int.bit.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val K = nextLongList()
    val sum = K.sum()

    var ans = Long.MAX_VALUE
    for (i in range(1 shl N)) {
        var A = 0L
        for (j in range(N)) {
            if (i.bit(j)) A += K[j]
        }
        ans = min(ans, max(A, sum - A))
    }
    println(ans)
}
