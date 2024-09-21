package com.github.ked4ma.atcoder.abc372

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val H = nextIntList()
    val stack = Stack<Int>()
    val ans = sizedIntArray(N, 0)
    for (i in N - 2 downTo 0) {
        while (stack.isNotEmpty() && stack.peek() < H[i + 1]) {
            stack.pop()
        }
        stack.push(H[i + 1])
        ans[i] = stack.size
    }
    println(ans.joinToString(" "))
}
