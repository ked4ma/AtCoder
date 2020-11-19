package com.github.khronos227.atcoder.abc060_na

import kotlin.math.max

fun main() {
    val (n, W) = nextLongList().let { (n, w) -> n.toInt() to w }
    val (wi, vi) = nextLongList()
    val (v0, v1, v2, v3) = {
        val v0 = mutableListOf<Long>()
        val v1 = mutableListOf<Long>()
        val v2 = mutableListOf<Long>()
        val v3 = mutableListOf<Long>()
        v0.add(vi)
        repeat(n - 1) {
            val (w, v) = nextLongList()
            when ((w - wi) % 4) {
                1L -> v1
                2L -> v2
                3L -> v3
                else -> v0
            }.add(v)
        }
        listOf(v0, v1, v2, v3).map { it.sortedDescending() }
    }().map { it.cumulativeSum() }

    var ans = 0L
    for (i0 in v0.indices) {
        val w0 = i0 * wi
        if (w0 > W) break
        for (i1 in v1.indices) {
            val w1 = i1 * (wi + 1) + w0
            if (w1 > W) break
            for (i2 in v2.indices) {
                val w2 = i2 * (wi + 2) + w1
                if (w2 > W) break
                for (i3 in v3.indices) {
                    val w3 = i3 * (wi + 3) + w2
                    if (w3 > W) break
                    ans = max(ans, v0[i0] + v1[i1] + v2[i2] + v3[i3])
                }
            }
        }
    }
    println(ans)
}

// # Utils
// ## Input
fun next() = readLine()!!
fun nextInt() = next().toInt()
fun nextLong() = next().toLong()
fun nextDouble() = next().toDouble()
fun nextList() = next().split(" ")
fun nextIntList() = nextList().map(String::toInt)
fun nextLongList() = nextList().map(String::toLong)
fun nextDoubleList() = nextList().map(String::toDouble)

// ## Array
inline fun <reified T> sizedArray(size: Int, default: T) = Array(size) { default }
inline fun <reified T> sized2DArray(row: Int, column: Int, default: T) = Array(row) { Array(column) { default } }

// ## List
/**
 * this is coppy of Iterator<>.scanReduce because of its experimentation stage
 */
private inline fun <T : Number, R : T> List<R>.cumulative(operation: (acc: T, l: R) -> T): List<T> {
    val iterator = this.iterator()
    if (!iterator.hasNext()) return emptyList()
    var accumulator: T = iterator.next()
    val result = ArrayList<T>(size).apply { add(accumulator) }
    while (iterator.hasNext()) {
        accumulator = operation(accumulator, iterator.next())
        result.add(accumulator)
    }
    return result
}

private fun List<Long>.cumulativeSum(): List<Long> = (listOf(0L) + this).cumulative { acc, l -> acc + l }

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

const val MOD = 1_000_000_007L
fun Long.plusMod(n: Long, mod: Long = MOD) = this.plus(n, mod)
fun Long.minusMod(n: Long, mod: Long = MOD) = this.minus(n, mod)
fun Long.timesMod(n: Long, mod: Long = MOD) = this.times(n, mod)
fun Long.divMod(n: Long, mod: Long = MOD) = this.div(n, mod)
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
class UnionFind(val size: Int) {
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