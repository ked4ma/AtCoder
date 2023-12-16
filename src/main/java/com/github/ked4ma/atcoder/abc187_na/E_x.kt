package com.github.ked4ma.atcoder.abc187_na

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*
import java.util.*

fun main() {
    val n = nextInt()
    val g = Array(n) { ArrayList<Int>(16) }
    val A = sizedArray(n - 1, 0)
    val B = sizedArray(n - 1, 0)
    repeat(n - 1) {
        val (a, b) = nextIntList().let { (a, b) -> a - 1 to b - 1 }
        g[a].add(b)
        g[b].add(a)
        A[it] = a
        B[it] = b
    }
    val dfs = ArrayList<Int>(16)
    val par = IntArray(n)
    val queue = Stack<Int>().apply { push(0) }
    while (queue.isNotEmpty()) {
        val u = queue.pop()
        dfs.add(u)
        for (v in g[u]) {
            if (par[u] == v) continue
            par[v] = u
            queue.push(v)
        }
    }
    val s = LongArray(n)
    repeat(nextInt()) {
        val (t, e, x) = nextIntList().let { (t, e, x) ->
            Triple(t, e - 1, x.toLong())
        }
        val a = if (t == 1) A[e] else B[e]
        val b = if (t == 2) A[e] else B[e]
        if (par[b] == a) {
            s[0] += x
            s[b] -= x
        } else {
            s[a] += x
        }
    }
    for (i in dfs) {
        for (v in g[i]) if (par[i] != v) {
            s[v] += s[i]
        }
    }
    println(s.joinToString("\n"))
}
