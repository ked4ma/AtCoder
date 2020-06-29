package com.github.khronos227.atcoder.abc172

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

// # Utils
// ## Input
fun next() = readLine()!!
fun nextInt() = next().toInt()
fun nextLong() = next().toLong()
fun nextDouble() = next().toDouble()
fun nextList() = next().split(" ")
fun nextIntList() = next().split(" ").map(String::toInt)
fun nextLongList() = next().split(" ").map(String::toLong)
fun nextDoubleList() = next().split(" ").map(String::toDouble)

// ## Array
inline fun <reified T> sizedArray(size: Int, default: T) = Array(size) { default }

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