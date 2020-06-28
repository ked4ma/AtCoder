package com.github.khronos227.atcoder.abc172

fun main() {
    val s = com.github.khronos227.atcoder.template.simple.next()
    val t = com.github.khronos227.atcoder.template.simple.next()
    var res = 0
    (s.indices).forEach {
        if (s[it] != t[it]) {
            res++
        }
    }
}
