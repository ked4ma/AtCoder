package com.github.ked4ma.atcoder.arc109

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (n, k) = nextIntList()
    var s = next().toCharArray()

    fun compete(a: Char, b: Char): Char {
        return when ("$a$b") {
            "RP" -> 'P'
            "RS" -> 'R'
            "PR" -> 'P'
            "PS" -> 'S'
            "SR" -> 'R'
            "SP" -> 'S'
            else -> a
        }
    }

    repeat(k) {
        val ns = s.clone()
        repeat(n) {
            ns[it] = compete(s[(2 * it) % n], s[(2 * it + 1) % n])
        }
        s = ns
    }
    println(s[0])
}
