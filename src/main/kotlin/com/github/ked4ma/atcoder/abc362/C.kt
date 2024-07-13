package com.github.ked4ma.atcoder.abc362

import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val LR = times(N) {
        val (l, r) = nextLongList()
        l to r
    }

    var sum = 0L
    val ans = sizedLongArray(N, 0)
    for (i in range(N)) {
        val (_, r) = LR[i]
        sum += r
        ans[i] = r
    }
    if (sum < 1) {
        println("No")
        return
    }
    for (i in range(N)) {
        val (l, r) = LR[i]
        if (sum == 0L) {
            break
        } else if (sum - r + l <= 0) {
            ans[i] = -(sum - r)
            sum = sum - r + ans[i]
        } else {
            ans[i] = l
            sum = sum - r + l
        }
    }
    if (sum == 0L) {
        println("Yes")
        println(ans.joinToString(" "))
    } else {
        println("No")
    }
}