package com.github.ked4ma.atcoder.abc377

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val set = mutableSetOf<Pair<Int, Int>>()
    val dirs = listOf(
        2 to 1,
        1 to 2,
        -1 to 2,
        -2 to 1,
        -2 to -1,
        -1 to -2,
        1 to -2,
        2 to -1,
    )
    repeat(M) {
        val (a, b) = nextIntList()
        set.add(a to b)
        for ((da, db) in dirs) {
            if (a + da in 1..N && b + db in 1..N) {
                set.add(a + da to b + db)
            }
        }
    }
    println(N.toLong() * N.toLong() - set.size)
}
