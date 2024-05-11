package com.github.ked4ma.atcoder.abc353

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var N = nextInt()
    val H = nextIntList()
    var ans = -1
    for (i in 1 until N) {
        if (H[0] < H[i]) {
            ans = i + 1
            break
        }
    }
    println(ans)
}
