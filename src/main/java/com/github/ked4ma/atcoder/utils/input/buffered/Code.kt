package com.github.ked4ma.atcoder.utils.input.buffered

// ## Input (with BufferedReader)
fun next(br: java.io.BufferedReader) = br.readLine()!!
fun nextInt(br: java.io.BufferedReader) = next(br).toInt()
fun nextLong(br: java.io.BufferedReader) = next(br).toLong()
fun nextDouble(br: java.io.BufferedReader) = next(br).toDouble()
fun nextList(br: java.io.BufferedReader) = next(br).split(" ")
fun nextIntList(br: java.io.BufferedReader) = nextList(br).map(String::toInt)
fun nextLongList(br: java.io.BufferedReader) = nextList(br).map(String::toLong)
fun nextDoubleList(br: java.io.BufferedReader) = nextList(br).map(String::toDouble)
