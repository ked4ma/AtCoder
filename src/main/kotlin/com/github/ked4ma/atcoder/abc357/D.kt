package com.github.ked4ma.atcoder.abc357

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.mod.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = 998244353L
    val N = nextLong()
    var carry = 1L
    repeat(N.toString().length) {
        carry = carry.timesMod(10, MOD)
    }
    _debug_println(carry)

    fun dfs(n: Long): Pair<Long, Long> {
        if (n == 1L) return N % MOD to carry
        val (h, c) = dfs(n / 2)
        var res = h.timesMod(c, MOD).plusMod(h, MOD)
        var resCarry = c.timesMod(c, MOD)
        if (n % 2 == 1L) {
            res = res.timesMod(carry, MOD).plusMod(N % MOD, MOD)
            resCarry = resCarry.timesMod(carry, MOD)
        }
        _debug_println("$res $resCarry")
        return res to resCarry
    }
    val (ans, _) = dfs(N)
    println(ans)
}
