package com.github.ked4ma.atcoder.abc378

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()

    val map = mutableMapOf<Int, Int>()
    val ans = sizedIntArray(N, -1)
    for (i in range(N)) {
        val a = A[i]
        if (a in map) {
            ans[i] = map.getValue(a)
        }
        map[a] = i + 1
    }
    println(ans.joinToString(" "))
}
