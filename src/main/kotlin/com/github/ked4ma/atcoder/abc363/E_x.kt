package com.github.ked4ma.atcoder.abc363

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.boolean.d2.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, Y) = nextIntList()
    val A = times(H) { nextIntList() }
    val queue = sizedArray(Y + 1) { ArrayDeque<Int>() }
    val inland = sized2DBooleanArray(H, W, true)

    for (h in range(H)) {
        for (w in range(W)) {
            if (h == 0 || h == H - 1 || w == 0 || w == W - 1) {
                if (A[h][w] <= Y) {
                    queue[A[h][w]].add(h * W + w)
                    inland[h][w] = false
                }
            }
        }
    }

    var ans = H * W
    val dirs = listOf(
        0 to 1,
        0 to -1,
        1 to 0,
        -1 to 0,
    )
    for (k in 1..Y) {
        while (queue[k].isNotEmpty()) {
            ans--
            val n = queue[k].removeFirst()
            val h = n / W
            val w = n % W
            for ((dh, dw) in dirs) {
                if (h + dh in range(H) && w + dw in range(W) && inland[h + dh][w + dw] && A[h + dh][w + dw] <= Y) {
                    queue[max(k, A[h + dh][w + dw])].addLast((h + dh) * W + (w + dw))
                    inland[h + dh][w + dw] = false
                }
            }
        }
        println(ans)
    }
}
