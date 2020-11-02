package com.github.khronos227.atcoder.abc181

fun main() {
    val n = nextInt()
    val points = (0 until n).map {
        val (x, y) = nextIntList()
        x to y
    }
    for (i in (0 until points.size - 2)) {
        val p1 = points[i]
        for (j in (i + 1 until points.size - 1)) {
            val p2 = points[j]
            val x12 = p1.first - p2.first
            val y12 = p1.second - p2.second
            for (k in (j + 1 until points.size)) {
                val p3 = points[k]
                val x23 = p2.first - p3.first
                val y23 = p2.second - p3.second
                if (x12 * y23 == y12 * x23) {
                    println("Yes")
                    return
                }

            }
        }
    }
    println("No")
}
