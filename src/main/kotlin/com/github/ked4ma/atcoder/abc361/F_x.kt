package com.github.ked4ma.atcoder.abc361

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextLong()

    fun pfact(x: Int): List<Int> {
        var xx = x
        val res = mutableListOf<Int>()
        var i = 2
        while (i * i <= xx) {
            while (xx % i == 0) {
                res.add(i)
                xx /= i
            }
            i++
        }
        if (x > 1) res.add(x)
        return res
    }

    fun safePow(a: Long, b: Int): Long {
        var res = 1L
        repeat(b) {
            var dres = res.toDouble()
            dres *= a
            if (dres >= Long.MAX_VALUE) return Long.MAX_VALUE
            res *= a
        }
        return res
    }

    var ans = 0L
    for (b in 2 until 60) {
        var l = 2L
        var r = Long.MAX_VALUE / 2
        while (l <= r) {
            val m = (l + r) / 2
            if (safePow(m, b) > N) {
                r = m - 1
            } else {
                l = m + 1
            }
        }
        val pf = pfact(b)
        var same = false
        for (i in 1 until pf.size) {
            if (pf[i - 1] == pf[i]) {
                same = true
                break
            }
        }
        if (same) continue
        if (pf.size % 2 == 1) {
            ans += (r - 1)
        } else {
            ans -= (r - 1)
        }
    }
    ans++
    println(ans)
}
