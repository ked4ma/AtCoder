package com.github.ked4ma.atcoder.abc363

import com.github.ked4ma.atcoder.utils.array.permutation.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val S = next().map { it - 'a' }

    val a = S.sorted().toIntArray()

    var ans = 0
    while (true) {
        var ok = true
        for (i in 0..N - K) {
            if (range(K / 2).all { k -> a[i + k] == a[i + K - 1 - k] }) ok = false
        }
        if (ok) ans++
        if (!a.nextPermutation()) break
    }
    println(ans)
}
//fun main() {
//    val (N, K) = nextIntList()
//    val S = next().toList()
//    fun factorial(n: Int) = (1L..n).fold(1L) { acc, m -> acc * m }
//
//    val group = S.groupingBy { it }.eachCount().toMutableMap()
//    val ALL = factorial(N) / group.values.fold(1L) { acc, m -> acc * factorial(m) }
//
//    val bag = mutableMapOf<String, Long>()
//    fun dfs(i: Int = 0, s: String = "") {
//        val l = s.length
//        if (i.countOneBits() >= K && range(K / 2).all { k -> s[l - K + k] == s[l - 1 - k] }) {
//            if (s !in bag) {
//                val list = group.values
//                bag[s] = factorial(list.sum()) / list.fold(1L) { acc, m -> acc * factorial(m) }
//            }
//            return
//        }
//        for (j in range(N)) {
//            if (!i.bit(j)) {
//                group[S[j]] = group.getValue(S[j]) - 1
//                dfs(i or (1 shl j), s + S[j])
//                group[S[j]] = group.getValue(S[j]) + 1
//            }
//        }
//    }
//    dfs()
//    _debug_println(bag.values.sum())
//    println(ALL - bag.values.sum())
//}
