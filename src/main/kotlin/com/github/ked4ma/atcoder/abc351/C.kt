package com.github.ked4ma.atcoder.abc351

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import java.util.Stack

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()
    val stack = Stack<Long>()
    for (i in range(N)) {
        stack.push(A[i])
        while (stack.size > 1 && stack[stack.size - 1] == stack[stack.size - 2]) {
            val a = stack.pop()
            val b = stack.pop()
            stack.push(a + 1)
        }
    }
    println(stack.size)
}
