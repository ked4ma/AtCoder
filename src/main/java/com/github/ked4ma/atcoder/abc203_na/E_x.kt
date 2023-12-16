package com.github.ked4ma.atcoder.abc203_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*

/**
 * it's important to reduce redundant calc cost
 */
@OptIn(ExperimentalStdlibApi::class)
fun main() {
    val (n, m) = nextIntList()
    val blacks = buildMap<Int, MutableSet<Int>> {
        repeat(m) {
            val (x, y) = nextIntList()
            put(x, getOrDefault(x, mutableSetOf()).apply { add(y) })
        }
    }
    val ans = mutableSetOf<Int>().apply { add(n) }

    for (i in blacks.keys.sorted()) {
        val blackSet = blacks.getValue(i)
        val ins = mutableSetOf<Int>()
        val rem = mutableSetOf<Int>()
        for (j in blackSet) {
            if (j - 1 in ans) {
                ins.add(j)
            } else if (j + 1 in ans) {
                ins.add(j)
            } else {
                rem.add(j)
            }
        }
        ans.removeAll(rem)
        ans.addAll(ins)
    }
    println(ans.count())
}
