package com.github.ked4ma.atcoder.abc357

import com.github.ked4ma.atcoder.utils.array.boolean.d1.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList().map { it - 1 }

    val visited = sizedBooleanArray(N, false)
    val loop = mutableSetOf<Int>()
    fun dfs(u: Int, v: MutableSet<Int> = mutableSetOf()) {
        if (visited[u]) {
            if (u in v) loop.add(u)
            return
        }
        visited[u] = true
        v.add(u)
        dfs(A[u], v)
    }
    for (i in range(N)) {
        if (visited[i]) continue
        dfs(i)
    }
    _debug_println(loop)
    val ans = sizedLongArray(N, 0)
    for (u in loop) {
        var cnt = 0L
        val visited = mutableSetOf<Int>()
        val queue = ArrayDeque<Int>()
        queue.addLast(u)
        while (queue.isNotEmpty()) {
            val v = queue.removeFirst()
            if (v in visited) break
            cnt++
            visited.add(v)
            queue.add(A[v])
        }
        for (v in visited) {
            ans[v] = cnt
        }
    }

    fun dfs2(u: Int): Long {
        if (ans[u] == 0L) {
            ans[u] = dfs2(A[u]) + 1
        }
        return ans[u]
    }
    for (i in range(N)) {
        dfs2(i)
    }
    println(ans.sum())
}
