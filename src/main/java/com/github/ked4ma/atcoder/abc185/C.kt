package com.github.ked4ma.atcoder.abc185

import com.github.ked4ma.atcoder.utils.input.default.*
import java.math.BigDecimal

fun main() {
    val l = nextInt()
    val n =  l - 1
    val r = l - 1 - 11
    var a = BigDecimal(1L)
    var b = BigDecimal(1L)
    repeat(r) {
        a *= BigDecimal(n - it)
        b *= BigDecimal(it + 1)
    }
    println(a / b)
}
