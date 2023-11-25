package com.github.ked4ma.atcoder.abc176

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*
import java.util.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val (h, w) = nextIntList()
    val (cy, cx) = nextIntList()
    val (dy, dx) = nextIntList().map { it - 1 }
    val map = (0 until h).map {
        next().toList().map { it.toString() }
    }
    val arrivalMap = sized2DArray(h, w, Int.MAX_VALUE)
    val queue = LinkedList<Point>()
    queue.add(Point(cx - 1, cy - 1, 0))
    while (queue.isNotEmpty()) {
        val point = queue.pollFirst()
        val x = point.x
        val y = point.y
        val v = point.v
        if (arrivalMap[y][x] <= v) continue
        arrivalMap[y][x] = v
        (max(y - 2, 0)..min(y + 2, h - 1)).forEach { nextY ->
            (max(x - 2, 0)..min(x + 2, w - 1)).forEach { nextX ->
                if (abs(nextY - y) + abs(nextX - x) < 2) {
                    if (map[nextY][nextX] == "." && arrivalMap[nextY][nextX] > v) {
                        queue.addFirst(Point(nextX, nextY, v))
                    }
                } else {
                    val nextV = v + 1
                    if (map[nextY][nextX] == "." && arrivalMap[nextY][nextX] > nextV) {
                        queue.add(Point(nextX, nextY, nextV))
                    }
                }
            }
        }
    }
    if (arrivalMap[dy][dx] > 1_000_000_000) {
        println(-1)
    } else {
        println(arrivalMap[dy][dx])
    }
}

data class Point(val x: Int, val y: Int, val v: Int)
