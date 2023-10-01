package com.github.ked4ma.atcoder.arc113_na

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val S = next().toCharArray()
    var index = S.size - 3
    var ans = 0L
    val opeSet = mutableSetOf<Int>()
    while (index >= 0) {
        if (S[index] == S[index + 1] && S[index] != S[index + 2]) {
            var count = 0
            for (i in (index + 2 until S.size)) {
                if (i in opeSet) {
                    if (S[index] != S[i]) {
                        count += S.size - i
                    }
                    break
                }
                if (S[index] != S[i]) {
                    count++
                }
            }
            opeSet.add(index)
            ans += count
            _debug_println("$ans ($count)")
        }
        index--
    }
    println(ans)
}
