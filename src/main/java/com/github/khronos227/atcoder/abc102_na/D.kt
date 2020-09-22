package com.github.khronos227.atcoder.abc102_na

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    nextIntList()
    val values = nextLongList()
    var sum = 0L
    val estValues = mutableListOf<Long>().apply {
        values.forEach {
            sum += it
            add(sum)
        }
    }.toList()

    fun separate(l: Int, r: Int, base: Long): Triple<Long, Long, Int> {
        var lVal = estValues[l]
        val mid = estValues[r - 1].plus(base).toDouble().div(2)
        var minDiff = abs(mid - lVal)
        var index = l + 1
        while (index < r && minDiff > abs(mid - estValues[index])) {
            lVal = estValues[index]
            minDiff = abs(mid - lVal)
            index++
        }
        val rVal = estValues[r - 1] - lVal
        lVal -= base
        return if (rVal < lVal) {
            Triple(rVal, lVal, index - 1)
        } else {
            Triple(lVal, rVal, index - 1)
        }
    }

    var res = Long.MAX_VALUE
    var li = 0
    var ri = 2
    (2..values.lastIndex.minus(1)).forEach {
        val (lMin, lMax, nli) = separate(li, it, 0)
        val (rMin, rMax, nri) = separate(ri, values.size, estValues[it - 1])
        val v = abs(max(lMax, rMax) - min(lMin, rMin))
        li = nli
        ri = nri
        res = min(res, v)
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