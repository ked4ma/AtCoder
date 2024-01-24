package com.github.ked4ma.atcoder.abc194_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val N = nextInt()
    var innerSum = 0L
    var sum = 0L
    val nums = nextLongList()
    repeat(N) {
        val n = nums[it]
        sum += (N - 1) * n * n
        if (it > 0) {
            sum += -2 * (innerSum) * n
        }
        innerSum += n
    }
    println(sum)
}

fun main2() {
    val N = nextInt()
    val nums = nextLongList()

    var innerSum = 0L
    var sum = 0L
    nums.forEach { n ->
        sum += N * n * n
        innerSum += n
    }
    println(sum - innerSum * innerSum)
}

