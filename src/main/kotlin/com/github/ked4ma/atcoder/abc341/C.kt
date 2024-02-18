package com.github.ked4ma.atcoder.abc341

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, N) = nextIntList()
    val T = next()
    val S = times(H) {
        next().toCharArray()
    }.toTypedArray()

    val tmp = buildList {
        var i = 0
        var j = 0
        add(i to j)
        T.forEach {
            when (it) {
                'L' -> j--
                'R' -> j++
                'U' -> i--
                'D' -> i++
            }
            add(i to j)
        }
    }
    val minPH = tmp.minOf(Pair<Int, Int>::first)
    val minPW = tmp.minOf(Pair<Int, Int>::second)
    val points = tmp.map { (i, j) ->
        i - minPH to j - minPW
    }
    val ph = points.maxOf(Pair<Int, Int>::first) - points.minOf(Pair<Int, Int>::first) + 1
    val pw = points.maxOf(Pair<Int, Int>::second) - points.minOf(Pair<Int, Int>::second) + 1
    _debug_println("$ph, $pw")
    _debug_println(points)

    var ans = 0
    for (i in 1..H - 1 - ph) {
        for (j in 1..W - 1 - pw) {
            if (points.all { (pi, pj) ->
                    S[i + pi][j + pj] == '.'
                }) {
                ans++
            }
        }
    }
    println(ans)
}