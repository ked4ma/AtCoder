package com.github.ked4ma.atcoder.abc376

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val (N, Q) = nextIntList()
    var ans = 0
    var l = 0
    var r = 1

    fun move(from: Int, to: Int, ng: Int): Int {
        return if (ng in min(from, to)..max(from, to)) {
            N - abs(to - from)
        } else {
            abs(to - from)
        }
    }
    repeat(Q) {
        val (H, T) = nextList().let { (H, T) -> H to T.toInt() - 1 }
        when(H) {
            "L" -> {
                ans += move(l, T, r)
                l = T
            }
            "R" -> {
                ans += move(r, T, l)
                r = T
            }
        }
    }
    println(ans)

//    repeat(Q) {
//        val (H, T) = nextList().let { (H, T) -> H to T.toInt() - 1 }
//        when (H) {
//            "L" -> {
//                if (T - l <= N / 2) {
//                    val range = min(l, T)..max(l, T)
//                    if (r in range) {
//                        ans += N - abs(T - l)
//                    } else {
//                        ans += abs(T - l)
//                    }
//                } else {
//                    if (r in 0..l || r in T..N - 1) {
//                        ans += abs(T - l)
//                    } else {
//                        ans += N - abs(T - l)
//                    }
//                }
//                l = T
//            }

//            "R" -> {
//                if (T - r <= N / 2) {
//                    val range = min(r, T)..max(r, T)
//                    if (l in range) {
//                        ans += N - abs(T - r)
//                    } else {
//                        ans += abs(T - r)
//                    }
//                } else {
//                    if (l in 0..r || l in T..N - 1) {
//                        ans += abs(T - r)
//                    } else {
//                        ans += N - abs(T - r)
//                    }
//                }
//                r = T
//            }
//        }
//        _debug_println(ans)
//    }
//    println(ans)
}
