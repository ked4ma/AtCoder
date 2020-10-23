package com.github.khronos227.atcoder.abc050_na

import kotlin.math.floor
import kotlin.math.log2

fun main() {
    val mod = 1_000_000_007L
    val n = nextLong()
    val len = floor(log2(n.toDouble())).toInt() + 1
    val dp = sized2DArray(len, 3, 0L)

    dp[len - 1][0] = 1
    dp[len - 1][1] = 1
    for (i in len - 2 downTo 0) {
        if ((n shr i) % 2 == 1L) {
            // diff of previous bit = 0
            // and if a[i] = 1 && b[i] = 1, a + b will be larger than N
            dp[i][0] = dp[i + 1][0]
            // diff of current bit = 0, previous = 1
            // diff of current bit = 1, previous = 0
            dp[i][1] = dp[i + 1][1].plus(dp[i + 1][0], mod)
            dp[i][2] = dp[i + 1][2].times(3).plus(dp[i + 1][1].times(2, mod), mod)
        } else {
            dp[i][0] = dp[i + 1][0].plus(dp[i + 1][1], mod)
            dp[i][1] = dp[i + 1][1]
            dp[i][2] = dp[i + 1][2].times(3).plus(dp[i + 1][1], mod)
        }
    }
    println(dp[0].sum().rem(mod))
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
inline fun <reified T> sized2DArray(row: Int, column: Int, default: T) = Array(row) { Array(column) { default } }

// ## mod^-1
//    [NOTE] CANNOT use this for 0, mod, 2mod, 3mod ...(return wrong value)
fun modinv(num: Long, mod: Long): Long {
    var a = num
    var b = mod
    var u = 1L
    var v = 0L
    while (b > 0) {
        val t = a.div(b)
        println("t: $t a: $a b: $b u: $u v: $v")
        a -= t * b
        a = b.also { b = a } // swap a and b
        u -= t * v
        u = v.also { v = u } // swap u and v
    }
    u %= mod
    println("$u $v")
    if (u < 0) u += mod
    return u
}

fun Long.plus(n: Long, mod: Long) = (this + n) % mod
fun Long.minus(n: Long, mod: Long) = (this - n + mod) % mod
fun Long.times(n: Long, mod: Long) = (this * n) % mod
fun Long.div(n: Long, mod: Long) = this * modinv(n, mod)

// gcd
fun gcd(x: Int, y: Int): Int {
    fun innerGcd(x: Int, y: Int): Int {
        return if (x % y == 0) y else innerGcd(y, x % y)
    }
    return if (x >= y) innerGcd(x, y) else innerGcd(y, x)
}

fun gcd(x: Long, y: Long): Long {
    fun innerGcd(x: Long, y: Long): Long {
        return if (x % y == 0L) y else innerGcd(y, x % y)
    }
    return if (x >= y) innerGcd(x, y) else innerGcd(y, x)
}

// classes
class UnionFindTree(val size: Int) {
    private val r = sizedArray(size, -1)
    fun root(x: Int): Int {
        if (r[x] < 0) return x
        return root(r[x])
    }

    fun unite(x: Int, y: Int) {
        var rx = root(x)
        var ry = root(y)
        if (rx == ry) return
        if (r[rx] > r[ry]) {
            rx = ry.also { ry = rx }
        }
        r[rx] += r[ry]
        r[ry] = rx
    }

    fun size(x: Int) = -r[root(x)]
    val categories: List<Int>
        get() = r.indices.map { root(it) }

    override fun toString(): String {
        return r.joinToString(separator = ", ")
    }
}