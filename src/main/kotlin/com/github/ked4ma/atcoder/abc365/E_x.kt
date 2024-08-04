package com.github.ked4ma.atcoder.abc365

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()
    var ans = 0L
    for (i in range(30)) {
        var b = 0
        val cnt = longArrayOf(1, 0)
        for (a in A) {
            b = b xor ((a shr i) and 1).toInt()
            cnt[b]++
        }
        _debug_println(cnt.joinToString(" "))
        ans += (cnt[0] * cnt[1]) shl i
    }
    println(ans - A.sum())
}

// DP ver.
//fun main() {
//    val N = nextInt()
//    val A = nextLongList()
//    var ans = 0L
//    for (k in range(30)) {
//        var dp = sized2DLongArray(3, 2, 0)
//        dp[0][0] = 1
//        for (i in range(N)) {
//            val x = ((A[i] shr k) and 1).toInt()
//            val next = sized2DLongArray(3, 2, 0)
//            for (j in range(3)) {
//                for (k2 in range(2)) {
//                    for (nj in j until 3) {
//                        var nk = k2
//                        if (nj == 1 && x == 1) nk = nk xor 1
//                        next[nj][nk] += dp[j][k2]
//                    }
//                }
//            }
//            dp = next
//        }
//        ans += (dp[1][1] + dp[2][1]) shl k
//    }
//    println(ans - A.sum())
//}
