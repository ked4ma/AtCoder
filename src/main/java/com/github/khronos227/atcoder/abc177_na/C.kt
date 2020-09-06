package com.github.khronos227.atcoder.abc177_na

fun main() {
    val MOD = 1_000_000_007L
    var res = 0L
    var sumj = 0L

    val n = nextInt()
    val a = nextLongList()

    (n.minus(1) downTo 1).forEach { j ->
        sumj = sumj.plus(a[j]).rem(MOD)
        res = res.plus(sumj.times(a[j - 1]).rem(MOD)).rem(MOD)
    }

    println(res)
}
