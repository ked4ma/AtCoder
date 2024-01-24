package com.github.ked4ma.atcoder.arc110

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val nums = mutableListOf<Int>()
    val n = nextInt()
    var ans = 1L
    for (i in 2..n) {
        var v = i
        for (j in nums) {
            if (v % j == 0) {
                v /= j
            }
        }
        ans *= v
        nums.add(v)
    }
    ans += 1
    println(ans)

//    for (i in 2..n) {
//        println("$i : ${ans % i}")
//    }
}
