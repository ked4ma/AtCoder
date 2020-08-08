//package com.github.khronos227.atcoder.abc174
//
//fun main() {
//    val n = nextInt()
//    val c = next().toCharArray()
//    var l = 0
//    var r = n - 1
//    var count = 0
//
//    while (l < r) {
//        while (l < r && c[l] == 'R') {
//            l++
//        }
//        while (l < r && c[r] == 'W') {
//            r--
//        }
//        if (l < r) {
//            count++
//            l++
//            r--
//        }
//    }
//    println(count)
//}
//
//// # Utils
//// ## Input
//fun next() = readLine()!!
//fun nextInt() = next().toInt()
//fun nextLong() = next().toLong()
//fun nextDouble() = next().toDouble()
//fun nextList() = next().split(" ")
//fun nextIntList() = next().split(" ").map(String::toInt)
//fun nextLongList() = next().split(" ").map(String::toLong)
//fun nextDoubleList() = next().split(" ").map(String::toDouble)
//
//// ## Array
//inline fun <reified T> sizedArray(size: Int, default: T) = Array(size) { default }
//inline fun <reified T> sized2DArray(row: Int, column: Int, default: T) = Array(row) { Array(column) { default } }
//
//// ## mod^-1
////    [NOTE] CANNOT use this for 0, mod, 2mod, 3mod ...(return wrong value)
//fun modinv(num: Long, mod: Long): Long {
//    var a = num
//    var b = mod
//    var u = 1L
//    var v = 0L
//    while (b > 0) {
//        val t = a.div(b)
//        a -= t * b
//        a = b.also { b = a } // swap a and b
//        u -= t * v
//        u = v.also { v = u } // swap u and v
//    }
//    u %= mod
//    if (u < 0) u += mod
//    return u
//}