package com.github.ked4ma.atcoder.abc371

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// https://www.youtube.com/watch?v=7MY61SWS8cM
//
// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()

    val ans = sizedLongArray(N + 1, 0)
    A.toSet().forEach { a ->
        ans[a] = N.toLong() * (N + 1) / 2
    }
    val pre = sizedIntArray(N + 1, -1)
    for (i in range(N)) {
        val p = (i - pre[A[i]] - 1)
        ans[A[i]] -= p.toLong() * (p + 1) / 2
        pre[A[i]] = i
    }
    _debug_println(pre.joinToString(" "))
    A.toSet().forEach { a ->
        val p = N - 1 - pre[a]
        _debug_println("$a: $p")
        ans[a] -= p.toLong() * (p + 1) / 2
    }
    _debug_println(ans.joinToString(" "))
    println(ans.sum())

//    val N = nextInt()
//    val A = nextIntList()
//    var ans = 0L
//    val pre = sizedIntArray(N + 1, -1)
//    for (i in range(N)) {
//        ans += (i - pre[A[i]]).toLong() * (N - i)
//        pre[A[i]] = i
//    }
//    println(ans)
}
