package com.github.ked4ma.atcoder.abc370

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (L, R) = nextIntList()
    if ((L == 0 && R == 0) || (L== 1&&R==1)) {
        println("Invalid")
    } else if (L == 1) {
        println("Yes")
    } else {
        println("No")
    }
}
