package com.github.khronos227.atcoder.abc176

import kotlin.math.max

fun main() {
    val (H, W, M) = nextIntList()
    var maxH = 0
    var maxW = 0
    val countH = mutableMapOf<Int, Int>()
    val countW = mutableMapOf<Int, Int>()

    val input = (0 until M).map {
        val (h, w) = nextIntList()
        val valH = countH.getOrDefault(h, 0) + 1
        val valW = countW.getOrDefault(w, 0) + 1
        maxH = max(maxH, valH)
        maxW = max(maxW, valW)
        countH[h] = valH
        countW[w] = valW
        h to w
    }.toSet()
    val targetH = countH.filterValues { it == maxH }.keys
    val targetW = countW.filterValues { it == maxW }.keys
    val result = maxH + maxW - 1
    targetH.forEach { h ->
        targetW.forEach { w ->
            if (!input.contains(h to w)) {
                println(result + 1)
                return
            }
        }
    }
    println(result)
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