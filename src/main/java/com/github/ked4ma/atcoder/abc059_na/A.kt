package com.github.ked4ma.atcoder.abc059_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    println(nextList().map(String::first).map(Char::toUpperCase).joinToString(""))
}
