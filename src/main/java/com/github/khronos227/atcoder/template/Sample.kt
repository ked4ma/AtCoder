package com.github.khronos227.atcoder.template

fun main() {
    println("This is template.")
    println("1: Implement solution")
    println("2: ./gradlew run")
    println("     or")
    println("   ./gradlew run < [path/to/input.txt]")
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
