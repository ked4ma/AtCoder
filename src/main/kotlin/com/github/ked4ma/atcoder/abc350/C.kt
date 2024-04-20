package com.github.ked4ma.atcoder.abc350

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList().map { it - 1 }.toIntArray()

    val index = sizedIntArray(N, 0)
    A.forEachIndexed { i, a ->
        index[a] = i
    }

    val ans = mutableListOf<Pair<Int, Int>>()
    for (a in range(N)) {
        if (index[a] == a) continue
        val i = index[a]
        val b = A[a]
        val j = index[b]
        A[j] = a
        A[i] = b
        index[a] = j
        index[b] = i
        ans.add(if (i < j) i + 1 to j + 1 else j + 1 to i + 1)
    }

    println(ans.size)
    ans.forEach { (a, b) ->
        println("$a $b")
    }
    _debug_println(A.joinToString(", "))
}
