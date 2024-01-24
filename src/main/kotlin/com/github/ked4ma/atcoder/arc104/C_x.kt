package com.github.ked4ma.atcoder.arc104

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val n = nextInt()
    val aList = sizedArray(n, 0)
    val bList = sizedArray(n, 0)
    val tp = sizedArray(n * 2, 0)
    val com = sizedArray(n * 2, -1)

    var ng = false
    repeat(n) { i ->
        val (a, b) = nextIntList()
        aList[i] = a
        bList[i] = b
        if (aList[i] != -1) {
            aList[i] = a - 1
            if (tp[aList[i]] != 0) ng = true
            tp[aList[i]] = i + 1
        }
        if (bList[i] != -1) {
            bList[i] = b - 1
            if (tp[bList[i]] != 0) ng = true
            tp[bList[i]] = -(i + 1)
        }
        if (aList[i] != -1 && bList[i] != -1) {
            com[aList[i]] = bList[i]
            com[bList[i]] = aList[i]
        }
    }

    if (ng) {
        println("No")
        return
    }

    val dp = sizedArray(n * 2 + 1, false)
    dp[0] = true

    repeat(n * 2) { i ->
        if (!dp[i]) return@repeat

        ((i + 1) until n * 2).forEach { j ->
            var w = j - i + 1
            if (w % 2 != 0) return@forEach // area size must be 2x
            w /= 2
            var ok = true
            val exist = sizedArray(n, false)

            repeat(w) { k ->
                val p = i + k
                val q = i + k + w
                if (com[p] != -1 && com[p] !in i..j) {
                    ok = false
                }
                if (com[q] != -1 && com[q] !in i..j) {
                    ok = false
                }

                var same = false
                if (tp[p] != 0 && tp[q] != 0) {
                    if (tp[p] < 0 || tp[p] + tp[q] != 0) {
                        ok = false
                    } else {
                        same = true
                    }
                }
                if (tp[p] < 0 || tp[q] > 0) {
                    ok = false
                } else {
                    if (tp[p] != 0) {
                        val v = tp[p] - 1
                        if (exist[v]) {
                            ok = false
                        }
                        exist[v] = true
                    }
                    if (!same && tp[q] != 0) {
                        val v = -tp[q] - 1
                        if (exist[v]) {
                            ok = false
                        }
                        exist[v] = true
                    }
                }
            }
            if (ok) {
                dp[j + 1] = true
            }
        }
    }
//    println(dp.joinToString(separator = ","))
    println(if (dp[n * 2]) "Yes" else "No")
}
