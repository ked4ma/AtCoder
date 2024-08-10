package com.github.ked4ma.atcoder.utils.input.default

// ## Input
fun next() = readln()
fun nextCharArray() = next().toCharArray()
fun nextInt() = readln().toInt()
fun nextLong() = next().toLong()
fun nextDouble() = next().toDouble()

fun nextIntList() = readln().split(" ").map(String::toInt)
fun nextList() = next().split(" ")
fun nextLongList() = nextList().map(String::toLong)
fun nextDoubleList() = nextList().map(String::toDouble)