package com.github.ked4ma.atcoder.abc378

import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.mod.*
import com.github.ked4ma.atcoder.utils.models.tree.fenwick.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextLongList()
    val cum = sizedLongArray(N + 1, 0)
    for (i in range(N)) {
        cum[i + 1] = (cum[i] + A[i]) % M
    }
    if (N == 3) {
        _debug_println(cum.joinToString(" "))
        _debug_println(cum[1].minusMod(cum[0], M.toLong()))
        _debug_println(cum[2].minusMod(cum[0], M.toLong()))
        _debug_println(cum[3].minusMod(cum[0], M.toLong()))
        _debug_println(cum[2].minusMod(cum[1], M.toLong()))
        _debug_println(cum[3].minusMod(cum[1], M.toLong()))
        _debug_println(cum[3].minusMod(cum[2], M.toLong()))
    }
    val ft = FenwickTree(M)
    var s = 0L
    var ans = 0L
    for (r in 1..N) {
        ans += cum[r] * r - s + M * ft.sum(cum[r].toInt() + 1, M)
        s += cum[r]
        ft.add(cum[r].toInt(), 1)
    }
    println(ans)
}
