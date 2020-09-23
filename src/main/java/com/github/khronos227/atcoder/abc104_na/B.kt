package com.github.khronos227.atcoder.abc104_na

fun main() {
    val s = next()
    if (s[0] != 'A' || s[1] !in ('a'..'z') || s.last() !in ('a'..'z')) {
        println("WA")
        return
    }
    var cCount = 0
    var otherCount = 0
    (1 until s.lastIndex).forEach {
        if (s[it] == 'C') {
            cCount++
        } else if (s[it] in 'A'..'C') {
            otherCount++
        }
    }
    println(
        if (cCount == 0 || cCount > 1 || otherCount > 0) {
            "WA"
        } else {
            "AC"
        }
    )
}
