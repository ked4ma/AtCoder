package com.github.khronos227.atcoder.aising2020_na

fun main() {
    val n = nextInt()
    val x = next().map { it.toString().toInt() }
    val popcount = x.filter { it == 1 }.size
    (1 until 2).forEach {
//        (0 until n).forEach {
        var count = 0
        val pcValue = x.mapIndexed { index, c ->
            if (index == it) {
                return@mapIndexed c.plus(1).rem(2)
            }
            c.toString().toInt()
        }.toMutableList()
//        var pc = Integer.toBinaryString(if (x[it] == '0') popcount + 1 else popcount - 1).map { it.toString().toInt() }
        println(pcValue)
        while (pcValue.any { it == 1 }) {
            val pc = Integer.toBinaryString(pcValue.count { it == 1 }).map { it.toString().toInt() }
            (0..pcValue.size.minus(pc.size)).forEach { baseIndex ->
                if (pcValue[baseIndex] == 1) {
                    pc.forEachIndexed { index, i ->
                        pcValue[baseIndex + index] = pcValue[baseIndex + index] xor i
                    }
                }
            }
            println(pc)
            println(pcValue)
            count++
        }
        println(count)
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