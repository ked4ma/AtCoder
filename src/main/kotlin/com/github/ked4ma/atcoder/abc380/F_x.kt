package com.github.ked4ma.atcoder.abc380

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, L) = nextIntList()
    val A = nextIntList()
    val B = nextIntList()
    val C = nextIntList()
    val ALL = A + B + C

    val arr = (A.map { 0 } + B.map { 1 } + C.map { 2 }).toIntArray()
    val dp = mutableMapOf<Pair<Int, Int>, Boolean>()
    fun dfs(i: Int = 0): Boolean {
        val n = i % 2
        val key = arr.contentHashCode() to n
        if (key in dp) {
            return dp.getValue(key)
        }
        for (j in range(N + M + L)) {
            if (arr[j] != n) continue
            arr[j] = 2
            if (!dfs(i + 1)) {
                dp[key] = true
                arr[j] = n
                return true
            }
            for (k in range(N + M + L)) {
                if (k == j || arr[k] != 2 || ALL[k] >= ALL[j]) continue
                arr[k] = n
                if (!dfs(i + 1)) {
                    dp[key] = true
                    arr[j] = n
                    arr[k] = 2
                    return true
                }
                arr[k] = 2
            }
            arr[j] = n
        }
        dp[key] = false
        return false
    }
    println(if (dfs()) "Takahashi" else "Aoki")
}
// fun main() {
//     val (N, M, L) = nextIntList()
//     val A = nextIntList()
//     val B = nextIntList()
//     val C = nextIntList()
//
//     val dp = mutableMapOf<Triple<List<Int>, List<Int>, Int>, Boolean>()
//
//     fun dfs(a: List<Int>, b: List<Int>, c: List<Int>, i: Int = 0): Boolean {
//         val key = Triple(a.sorted(), b.sorted(), i % 2)
//         if (key in dp) {
//             return dp.getValue(key)
//         }
//         if (i % 2 == 0) {
//             for (j in range(a.size)) {
//                 val n = a[j]
//                 val a2 = a.filterIndexed { index, _ -> index != j }
//                 if (!dfs(a2, b, c + n, i + 1)) {
//                     dp[key] = true
//                     return true
//                 }
//                 for (k in range(c.size)) {
//                     if (c[k] < n) {
//                         if (!dfs(a2 + c[k], b, c.filterIndexed { index, _ -> index != k } + n, i + 1)) {
//                             dp[key] = true
//                             return true
//                         }
//                     }
//                 }
//             }
//             dp[key] = false
//             return false
//         } else {
//             for (j in range(b.size)) {
//                 val n = b[j]
//                 val b2 = b.filterIndexed { index, _ -> index != j }
//                 if (!dfs(a, b2, c + n, i + 1)) {
//                     dp[key] = true
//                     return true
//                 }
//                 for (k in range(c.size)) {
//                     if (c[k] < n) {
//                         if (!dfs(a, b2 + c[k], c.filterIndexed { index, _ -> index != k } + n, i + 1)) {
//                             dp[key] = true
//                             return true
//                         }
//                     }
//                 }
//             }
//             dp[key] = false
//             return false
//         }
//     }
//     println(if (dfs(A, B, C, 0)) "Takahashi" else "Aoki")
// }