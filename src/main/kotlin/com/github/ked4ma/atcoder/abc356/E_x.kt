package com.github.ked4ma.atcoder.abc356

import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList().sorted()

    val cnt = sizedLongArray(A.last() + 1, 0)
    for (a in A) {
        cnt[a]++
    }
    for (i in range(A.last())) {
        cnt[i + 1] += cnt[i]
    }
    var ans = 0L
    for (c in 1..A.last()) {
        // d: count of "c"
        val d = cnt[c] - cnt[c - 1]
        // ⌊x⌋
        var k = 1
        while (k * c <= A.last()) {
            ans += k * (cnt[min(A.last(), (k + 1) * c - 1)] - cnt[k * c - 1]) * d
            k++
        }
        if (d > 0) {
            _debug_println("$c $d ${d * (d + 1) / 2}")
        }
        // if i know, may be able to write it, but i don't think i can do...
        ans -= d * (d + 1) / 2
    }
    println(ans)
}
