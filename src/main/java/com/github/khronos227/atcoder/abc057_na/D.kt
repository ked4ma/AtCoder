package com.github.khronos227.atcoder.abc057_na

import kotlin.math.max

fun main() {
    val (n, a, b) = nextIntList()
    val vList = nextLongList()

    val dp = sized2DArray(n + 1, n + 1, 0L to 0L)
    for (i in (0..n)) {
        dp[i][0] = 0L to 1L
    }

    for (i in (0 until n)) {
        val v = vList[i]
        for (j in (0..i)) {
            val value = max(
                dp[i][j + 1].first,
                dp[i][j].first + v
            )
            val count = (if (dp[i][j + 1].first == value) dp[i][j + 1].second else 0) +
                    (if (dp[i][j].first + v == value) dp[i][j].second else 0)
            dp[i + 1][j + 1] = value to count
        }
    }
//    dp.forEach {
//        println(it.joinToString(","))
//    }

    data class Fraction(val num: Long, val denom: Long) {
        val value: Double by lazy { num.toDouble() / denom }
    }

    dp.last().let { result ->
        val count = (a..b).map {
            val d = gcd(result[it].first, it.toLong())
            Fraction(result[it].first / d, it.toLong() / d) to result[it].second
        }.groupBy(Pair<Fraction, Long>::first, Pair<Fraction, Long>::second).mapKeys {
            it.key.value
        }.mapValues { (_, v) ->
            v.sum()
        }
        val avg = count.keys.max()
        println("%.6f".format(avg))
        println(count[avg])
    }
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

fun modinv2(a: Long, b: Long, x: Long, y: Long): Triple<Long, Long, Long> {
    if (b == 0L) {
        return Triple(a, 1, 0)
    }
    val (d, y2, x2) = modinv2(b, a % b, y, x)
    println("$d $x2 $y2 ${a / b}")
    return Triple(d, x2, y2 - a / b * x2)
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

    val roots: Array<Int> get() = (r.indices).map { root(it) }.toTypedArray()

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