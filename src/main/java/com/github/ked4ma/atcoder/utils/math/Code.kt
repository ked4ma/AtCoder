package com.github.ked4ma.atcoder.utils.math


fun Long.pow(n: Long): Long {
    if (n < 0) throw IllegalArgumentException("n($n) must be greater than or equal to zero(0).")
    var res = 1L
    for (i in 0 until n) {
        res *= this
    }
    return res
}

// mod
const val MOD = 1_000_000_007L
fun Long.plusMod(n: Long, mod: Long = MOD) = this.plus(n, mod)
fun Long.minusMod(n: Long, mod: Long = MOD) = this.minus(n, mod)
fun Long.timesMod(n: Long, mod: Long = MOD) = this.times(n, mod)
fun Long.divMod(n: Long, mod: Long = MOD) = this.div(n, mod)
fun Long.plus(n: Long, mod: Long) = (this + n) % mod
fun Long.minus(n: Long, mod: Long) = (this - n + mod) % mod
fun Long.times(n: Long, mod: Long) = (this * n) % mod
fun Long.div(n: Long, mod: Long) = this * modinv(n, mod)

// ## mod^-1
//    [NOTE] CANNOT use this for 0, mod, 2mod, 3mod ...(return wrong value)
fun modinv(num: Long, mod: Long): Long {
    var a = num
    var b = mod
    var u = 1L
    var v = 0L
    while (b > 0) {
        val t = a.div(b)
        a -= t * b
        a = b.also { b = a } // swap a and b
        u -= t * v
        u = v.also { v = u } // swap u and v
    }
    u %= mod
    if (u < 0) u += mod
    return u
}

fun modinv2(a: Long, b: Long, x: Long, y: Long): Triple<Long, Long, Long> {
    if (b == 0L) {
        return Triple(a, 1, 0)
    }
    val (d, y2, x2) = modinv2(b, a % b, y, x)
    return Triple(d, x2, y2 - a / b * x2)
}

// calc "x!"
fun factorial(x: Int): Long {
    if (x < 0) throw IllegalArgumentException("this need positive param")
    var res = 1L
    var i = 2
    while (i <= x) {
        res *= i
        i++
    }
    return res
}
