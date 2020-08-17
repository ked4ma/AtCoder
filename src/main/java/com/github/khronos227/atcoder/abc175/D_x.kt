package com.github.khronos227.atcoder.abc175

import kotlin.math.max

fun main() {
    val (n, k) = nextIntList()
    val p = nextIntList().map { it - 1 }
    val c = nextLongList()

    var res = Long.MIN_VALUE
    repeat(n) {
        var index = p[it]
        val l = mutableListOf<Int>()
        while (index != l.getOrNull(0)) {
            l.add(index)
            index = p[index]
        }

        var v = Long.MIN_VALUE
        var inner = 0L
        l.take(k).forEach { i ->
            inner += c[i]
            v = max(v, inner)
        }

        if (inner > 0 && k > l.size) {
            val num = k.minus(1).div(l.size)
            inner = inner.times(num)
            l.take(k.minus(l.size.times(num))).forEach { i ->
                inner += c[i]
                v = max(v, inner)
            }
        }
        res = max(res, v)
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