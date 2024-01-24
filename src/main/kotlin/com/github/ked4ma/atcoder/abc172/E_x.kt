package com.github.ked4ma.atcoder.abc172

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.modinv.*

fun main() {
    val (n, m) = nextIntList()
    val mod = 1_000_000_007L
    val factList = sizedArray(m + 1, 0L)
    val modInvList = sizedArray(m + 1, 0L)

    var a = 1L
    repeat(m + 1) {
        factList[it] = a
        modInvList[it] = modinv(a, mod)
        a = a.times(it.plus(1)).rem(mod)
    }
    var res = 0L
    repeat(n + 1) { k ->
        val c = factList[n].times(modInvList[k]).rem(mod).times(modInvList[n - k]).rem(mod)
        val p1 = factList[m].times(modInvList[m - k]).rem(mod)
        val p2 = factList[m - k].times(modInvList[m - n]).rem(mod)
        val t = c.times(p1).rem(mod).times(p2).rem(mod).times(p2).rem(mod)
        if (k % 2 == 0) {
            res = res.plus(t).rem(mod)
        } else {
            res -= t
            if (res < 0) {
                res += mod
            }
        }
    }
    println(res)
}
