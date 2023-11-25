package com.github.ked4ma.atcoder.abc198_na

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    val N = nextInt()
    val C = nextIntList()

    val mapping = (0 until N).map {
        mutableListOf<Int>()
    }

    repeat(N - 1) {
        val (A, B) = nextIntList()
        mapping[A - 1].add(B - 1)
        mapping[B - 1].add(A - 1)
    }

    val counts = sizedArray(101010, 0)
    val res = BooleanArray(N)

    val queue = ArrayDeque(listOf(0))
    val visited = BooleanArray(N)
    while (queue.isNotEmpty()) {
        val cur = queue.removeLast()

        if (cur >= 0) {
            visited[cur] = true

            if (counts[C[cur]] == 0) {
                res[cur] = true
            }

            counts[C[cur]]++

            queue.add(-1 - cur)
            for (dest in mapping[cur]) {
                if (visited[dest]) continue
                queue.addLast(dest)
            }
        } else {
            counts[C[-1 - cur]]--
        }
    }

    // [NOTE] dfs will throw stack overflow for too deep tree
    //    fun dfs(cur: Int, par: Int = -1) {
    //        if (counts[C[cur]] == 0) {
    //            res[cur] = true
    //        }
    //        counts[C[cur]]++
    //        for (dest in mapping[cur]) {
    //            if (dest != par) {
    //                dfs(dest, cur)
    //            }
    //        }
    //        counts[C[cur]]--
    //    }
    //
    //    dfs(0)

    res.forEachIndexed { index, b ->
        if (b) println(index + 1)
    }
}
