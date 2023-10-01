package com.github.ked4ma.atcoder.abc193_na

import com.github.ked4ma.atcoder.utils.gcd.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    repeat(nextInt()) {
        val (x, y, p, q) = nextLongList()
        var ans = Long.MAX_VALUE
        for (t1 in x until (x + y)) {
            for (t2 in p until p + q) {
                val (r, _) = crt(
                    listOf(t1, t2),
                    listOf(2 * (x + y), p + q)
                )
                if (r == 0L) continue
                if (ans > r) ans = r
            }
        }
        if (ans == Long.MAX_VALUE) {
            println("infinity")
        } else {
            println(ans)
        }
    }
}
