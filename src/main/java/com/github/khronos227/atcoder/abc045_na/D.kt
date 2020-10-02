package com.github.khronos227.atcoder.abc045_na

import kotlin.math.min

fun main() {
    val (h, w, n) = nextIntList()
    val list = mutableListOf<Pair<Int, Int>>()

    repeat(n) {
        val (a, b) = nextIntList()
        ((a - 3).coerceAtLeast(0) until min(a, h - 2)).forEach { da ->
            ((b - 3).coerceAtLeast(0) until min(b, w - 2)).forEach { db ->
                val p = da to db
                list.add(p)
            }
        }
    }
    val countArr = sizedArray(9, 0)
    if (list.isNotEmpty()) {
        list.sortWith(Comparator { o1, o2 ->
            val a = o1.first.compareTo(o2.first)
            if (a == 0) {
                o1.second.compareTo(o2.second)
            } else {
                a
            }
        })
        var count = 0
        var current = list.first()
        list.forEach {
            if (current == it) {
                count++
                return@forEach
            }
            countArr[count - 1]++
            current = it
            count = 1
        }
        countArr[count - 1]++
    }
    println((h.toLong().minus(2) * w.toLong().minus(2)) - countArr.sum())
    (1..9).forEach {
        println(countArr[it - 1])
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
        a -= t * b
        a = b.also { b = a } // swap a and b
        u -= t * v
        u = v.also { v = u } // swap u and v
    }
    u %= mod
    if (u < 0) u += mod
    return u
}

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

    override fun toString(): String {
        return r.joinToString(separator = ", ")
    }
}