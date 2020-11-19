package com.github.khronos227.atcoder.abc183

fun main() {
    val (n, w) = nextLongList().let { (n, w) ->
        n.toInt() to w
    }
    val sched = (0 until n).flatMap {
        val (s, t, p) = nextLongList()
        listOf(s.toInt() to p, t.toInt() to -p)
    }.groupBy(Pair<Int, Long>::first, Pair<Int, Long>::second).mapValues { (_, v) ->
        v.sum()
    }.toList().sortedBy { it.first }
    var curr = 0L
    for ((_, p) in sched) {
        curr += p
        if (curr > w) {
            println("No")
            return
        }
    }
    println("Yes")
}
