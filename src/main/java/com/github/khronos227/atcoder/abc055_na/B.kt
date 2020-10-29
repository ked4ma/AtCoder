package com.github.khronos227.atcoder.abc055_na

fun main() {
    val mod = 1_000_000_007L
    val n = nextInt()
    var ans = 1L
    repeat(n) {
        ans = ans.times((it + 1).toLong(), mod)
    }
    println(ans)
}
