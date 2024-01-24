package com.github.ked4ma.atcoder.abc323

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*
import com.github.ked4ma.atcoder.utils.math.mod.*
import com.github.ked4ma.atcoder.utils.math.modinv.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val MOD = 998244353L
    val (N, X) = nextIntList()
    val T = nextIntList()
    val Ninv = modinv(N.toLong(), MOD)

    var ans = 0L
    val p = sizedArray(X + 1, 0L)
    p[0] = 1
    if (T[0] > X) {
        ans = ans.plusMod(p[0].timesMod(Ninv, MOD), MOD)
    }
    _debug_println(ans)
    (1..X).forEach { i ->
        (0 until N).filter { j ->
            T[j] <= i
        }.forEach { j ->
            p[i] = p[i].plusMod(p[i - T[j]], MOD)
        }
        p[i] = p[i].timesMod(Ninv, MOD)
        if (i + T[0] > X) {
            ans = ans.plusMod(p[i].timesMod(Ninv, MOD), MOD)
        }
    }
    println(ans)
}
//fun main() {
//    val MOD = 998244353L
//    val (N, X) = nextIntList()
//    val T = nextIntList()
//    val min = T.min()
//    // modinv(x, MOD) * y) % MOD) = z
//    // _debug_println((modinv(27, MOD) * 7) % MOD)
//    val maxCount = ((X + 0.5) / min).toInt() + 1
//    val x = N.toLong().pow(maxCount)
//
//    _debug_println(maxCount)
//    var y = 0L
//    val dp = sized2DArray(N, X + 2, 0)
//    fun dfs(rem: Double, count: Int = 1) {
//        if (rem < 0) return
//        if (T[0] > rem) {
//            y += N.toLong().pow(maxCount - count)
//            return
//        }
//        T.forEach { t ->
//            dfs(rem - t, count + 1)
//        }
//    }
//    dfs(X + 0.5)
//    println((modinv(x, MOD) * y) % MOD)
//}