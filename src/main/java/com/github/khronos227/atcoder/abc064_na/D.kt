package com.github.khronos227.atcoder.abc064_na

import com.github.khronos227.atcoder.utils.next
import com.github.khronos227.atcoder.utils.nextInt
import java.util.*

fun main() {
    nextInt()
    val s = ArrayDeque(next().toCharArray().asList())
    val sb = StringBuilder()
    var l = 0
    while (s.isNotEmpty()) {
        val c = s.poll()
        sb.append(c)
        when (c) {
            '(' -> {
                l++
            }
            ')' -> {
                if (l == 0) {
                    sb.insert(0, '(')
                } else {
                    l--
                }
            }
        }
    }
    repeat(l) {
        sb.append(')')
    }
    println(sb)
}
