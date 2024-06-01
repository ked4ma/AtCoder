package com.github.ked4ma.atcoder.abc356

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.mod.*
import com.github.ked4ma.atcoder.utils.number.long.bit.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextLongList()
    val MOD = 998244353L

    _debug_println(_debug_to_bit(N))
    fun f(n: Long): Long {
        _debug_println("n = $n")
        _debug_println(_debug_to_bit(n))
        if (n == 0L) return 0L
        if (n == 1L) return 1L
        val k = n.bitLength() - 1
        _debug_println(k)
        val a = (((1L shl k) - 1) and M).countOneBits().toLong().timesMod((1L shl (k - 1)) % MOD, MOD)
        _debug_println(a)
        val b = f(n - ((1L shl k)))
        _debug_println(b)
        val c = if (M.bit(k)) n - ((1L shl k) - 1) else 0
        _debug_println(c)
        return a.mod(MOD).plusMod(b, MOD).plusMod(c, MOD)
    }

    println(f(N))
}
