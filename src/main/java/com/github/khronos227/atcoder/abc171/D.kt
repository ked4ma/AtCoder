package com.github.khronos227.atcoder.abc171

import com.github.khronos227.atcoder.utils.*

fun main() {
    nextInt()
    val valueMap = mutableMapOf<Int, Int>()
    var sum = 0L
    nextIntList().forEach {
        sum += it
        valueMap[it] = valueMap.getOrDefault(it, 0) + 1
    }
    val q = nextInt()
    repeat(q) {
        val (b, c) = nextIntList()
        val bNum = valueMap.getOrDefault(b, 0)
        val cNum = valueMap.getOrDefault(c, 0)
        sum += c.minus(b).times(bNum)
        valueMap.remove(b)
        valueMap[c] = cNum + bNum
        println(sum)
    }
}
