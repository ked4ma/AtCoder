package com.github.ked4ma.atcoder.utils.math.mod

import com.github.ked4ma.atcoder.utils.math.modinv.*

// mod
const val MOD = 1_000_000_007L
fun Long.plusMod(n: Long, mod: Long = MOD) = this.plus(n, mod)
fun Long.minusMod(n: Long, mod: Long = MOD) = this.minus(n, mod)
fun Long.timesMod(n: Long, mod: Long = MOD) = this.times(n, mod)
fun Long.divMod(n: Long, mod: Long = MOD) = this.div(n, mod)
fun Long.plus(n: Long, mod: Long) = (this + n) % mod
fun Long.minus(n: Long, mod: Long) = (this - n + mod) % mod
fun Long.times(n: Long, mod: Long) = (this * n) % mod
fun Long.div(n: Long, mod: Long) = (this * modinv(n, mod)) % mod
