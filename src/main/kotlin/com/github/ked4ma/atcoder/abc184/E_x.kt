package com.github.ked4ma.atcoder.abc184

import com.github.ked4ma.atcoder.utils.array.any.d2.*
import com.github.ked4ma.atcoder.utils.input.default.*
import java.util.*

fun main() {
    val (h, w) = nextIntList()
    val board = (0 until h).map {
        next().toCharArray()
    }
    var sx = 0
    var sy = 0
    var gx = 0
    var gy = 0
    val warpsTmp = mutableListOf<Pair<Char, Pair<Int, Int>>>()
    board.forEachIndexed { y, chars ->
        chars.forEachIndexed { x, c ->
            when (c) {
                'S' -> {
                    sx = x
                    sy = y
                }

                'G' -> {
                    gx = x
                    gy = y
                }

                in 'a'..'z' -> {
                    warpsTmp.add(c to (x to y))
                }
            }
        }
    }
    val warps = warpsTmp.groupBy({ it.first }) {
        it.second
    }.toMutableMap()

    val costs = sized2DArray(h, w, Long.MAX_VALUE)
    costs[sy][sx] = 0L
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(sx to sy)

    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(1, 0, -1, 0)
    while (queue.isNotEmpty()) {
        val (x, y) = queue.pop()
        val cost = costs[y][x] + 1
        for (i in 0 until 4) {
            val x2 = x + dx[i]
            val y2 = y + dy[i]
            if (x2 !in 0 until w || y2 !in 0 until h || board[y2][x2] == '#') continue
            if (costs[y2][x2] > cost) {
                queue.add(x2 to y2)
                costs[y2][x2] = cost
            }
        }
        if (board[y][x] in 'a'..'z') {
            warps.getValue(board[y][x]).forEach { (wx, wy) ->
                if (wx == x && wy == y) return@forEach
                if (costs[wy][wx] > cost) {
                    queue.add(wx to wy)
                    costs[wy][wx] = cost
                }
            }
            warps[board[y][x]] = emptyList()
        }
    }

    println(if (costs[gy][gx] == Long.MAX_VALUE) -1 else costs[gy][gx])
}
