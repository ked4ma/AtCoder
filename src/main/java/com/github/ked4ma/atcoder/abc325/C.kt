package com.github.ked4ma.atcoder.abc325

import com.github.ked4ma.atcoder.utils.array.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.loop.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val S = times(H) {
        next().toCharArray().toTypedArray()
    }.toTypedArray()
    val visited = sized2DArray(H, W, false)
    val arrounds = arrayOf(
        -1 to -1,
        -1 to 0,
        -1 to 1,
        0 to -1,
        0 to 1,
        1 to -1,
        1 to 0,
        1 to 1,
    )

    fun check(h: Int, w: Int): Boolean {
        if (h < 0 || h >= H || w < 0 || w >= W) return false
        return S[h][w] == '#'
    }

    var count = 0
    repeat(H) { r ->
        repeat(W) { c ->
            if (S[r][c] != '#' || visited[r][c]) return@repeat
            count++
            val queue = ArrayDeque<Pair<Int, Int>>()
            queue.addLast(r to c)
            _debug_println("-----")
            while (queue.isNotEmpty()) {
                val (h, w) = queue.removeFirst()
                _debug_println("$h $w")
                if (visited[h][w]) continue
                visited[h][w] = true
                for ((dh, dw) in arrounds) {
                    if (check(h + dh, w + dw)) {
                        queue.addLast(h + dh to w + dw)
                    }
                }
            }
        }
    }
    println(count)
}