package com.github.ked4ma.atcoder.abc201_na

import com.github.ked4ma.atcoder.utils.array.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val input = next().toCharArray()
    var count = 0
    val numArr = sizedArray(10, 0)
    for (i in 0..9) {
        numArr[i]++
        for (j in 0..9) {
            numArr[j]++
            for (m in 0..9) {
                numArr[m]++
                for (n in 0..9) {
                    numArr[n]++

                    val isValid = input.zip(numArr).all { (ch, c) ->
                        when (ch) {
                            'o' -> c > 0
                            'x' -> c == 0
                            else -> true
                        }
                    }
                    if (isValid) {
                        count++
                    }

                    numArr[n]--
                }
                numArr[m]--
            }
            numArr[j]--
        }
        numArr[i]--
    }
    println(count)
}
