package com.github.ked4ma.atcoder.abc294_na

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.loop.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (L, N1, N2) = nextLongList()
    val X1 = buildList<Pair<LongRange, Long>> {
        var i = 0L
        repeat(N1) {
            val (v, l) = nextLongList()
            add((i until i + l) to v)
            i += l
        }
    }
    val X2 = buildList<Pair<LongRange, Long>> {
        var i = 0L
        repeat(N2) {
            val (v, l) = nextLongList()
            add((i until i + l) to v)
            i += l
        }
    }
    var i1 = 0
    var i2 = 0
    var count = 0L
    while (i1 < N1 && i2 < N2) {
        if (X1[i1].second == X2[i2].second) {
            val start = max(X1[i1].first.first, X2[i2].first.first)
            val end = min(X1[i1].first.last, X2[i2].first.last)
            count += end - start + 1
        }
        if (X1[i1].first.last <= X2[i2].first.last) {
            i1++
        } else {
            i2++
        }
        _debug_println(count)
    }
    println(count)
}