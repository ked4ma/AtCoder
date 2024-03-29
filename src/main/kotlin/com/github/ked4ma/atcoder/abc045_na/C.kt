package com.github.ked4ma.atcoder.abc045_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val s = next().toCharArray().toList()

    fun calc(from: Int = 0, end: Int = 1, sum: Long = 0): Long {
        val base = s.subList(from, end).joinToString(separator = "").toLong()
        if (end == s.size) return sum + base

        return calc(from, end + 1, sum) + calc(end, end + 1, sum + base)
    }

    println(calc())
}
