package com.github.khronos227.atcoder.abc051_na

import kotlin.math.min

fun main() {
    val (n, m) = nextIntList()
    val a = sizedArray(m, 0)
    val b = sizedArray(m, 0)
    val c = sizedArray(m, 0)
    val dist = sized2DArray(n, n, 100_000_000)
    repeat(n) {
        dist[it][it] = 0
    }
    repeat(m) {
        val (ta, tb, tc) = nextIntList()
        a[it] = ta - 1
        b[it] = tb - 1
        c[it] = tc

        dist[a[it]][b[it]] = c[it]
        dist[b[it]][a[it]] = c[it]
    }
    // Warshall–Floyd Algorithm
    for (k in (0 until n)) {
        for (i in (0 until n)) {
            for (j in (0 until n)) {
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
            }
        }
    }

    var res = m
    for (i in (0 until m)) {
        var shortest = false
        for (j in (0 until n)) {
            if (dist[j][a[i]] + c[i] == dist[j][b[i]]) shortest = true
        }
        if (shortest) res--
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