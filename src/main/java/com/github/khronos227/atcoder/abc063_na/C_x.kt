package com.github.khronos227.atcoder.abc063_na

fun main() {
    val n = nextInt()
    val s = (0 until n).map { nextInt() }
    val odds = s.filter { it % 10 != 0 }.sorted()

    val sum = s.sum()
    if (sum % 10 == 0) {
        if (odds.isNotEmpty()) {
            println(sum - odds.first())
        } else {
            println(0)
        }
    } else {
        println(sum)
    }
}
