package com.github.ked4ma.atcoder.abc062_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*
import java.util.*
import kotlin.math.max

fun main() {
    val n = nextInt()
    val a = nextLongList()
    val b = a.asReversed()
    val queueMin = PriorityQueue<Long>(compareBy { -it }).apply { addAll(b.subList(0, n)) }
    var rightSum = queueMin.sum()
    val minList = mutableListOf(rightSum)
    for (k in n until 2 * n) {
        queueMin.add(b[k])
        rightSum += b[k] - queueMin.poll()
        minList.add(rightSum)
    }
    val queue = PriorityQueue<Long>().apply { addAll(a.subList(0, n - 1)) }
    var leftSum = queue.sum()

    var ans = Long.MIN_VALUE
    for (k in n - 1 until 2 * n) {
        queue.add(a[k])
        leftSum += a[k]

        ans = max(
            ans,
            leftSum - minList[2 * n - k - 1]
        )
        // println("$leftSum ${minList[2 * n - k - 1]}")

        leftSum -= queue.poll()
    }

    println(ans)
}
