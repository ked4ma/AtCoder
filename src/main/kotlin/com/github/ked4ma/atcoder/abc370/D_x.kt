package com.github.ked4ma.atcoder.abc370

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, Q) = nextIntList()

    val tate = sizedArray(W) { sortedSetOf<Int>() }
    val yoko = sizedArray(H) { sortedSetOf<Int>() }
    for (h in range(H)) {
        for (w in range(W)) {
            tate[w].add(h)
            yoko[h].add(w)
        }
    }

    fun erase(h: Int, w: Int) {
        yoko[h].remove(w)
        tate[w].remove(h)
    }

    repeat(Q) {
        val (R, C) = nextIntList().map { it - 1 }
        if (C in yoko[R]) {
            erase(R, C)
            return@repeat
        }
        // up
        run {
            tate[C].floor(R)?.let { r ->
                erase(r, C)
            }
        }
        // down
        run {
            tate[C].ceiling(R)?.let { r ->
                erase(r, C)
            }
        }
        // left
        run {
            yoko[R].floor(C)?.let { c ->
                erase(R, c)
            }
        }
        // right
        run {
            yoko[R].ceiling(C)?.let { c ->
                erase(R, c)
            }
        }
    }
    println(yoko.sumOf { it.size })
}
