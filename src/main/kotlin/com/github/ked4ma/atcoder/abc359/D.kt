package com.github.ked4ma.atcoder.abc359

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.mod.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = 998_244_353L
    val (N, K) = nextIntList()
    val S = next().toCharArray()
    var map = mapOf("C".repeat(K - 1) to 1L)
    for (i in 1..N) {
        val tmp = buildMap {
            when (S[i - 1]) {
                'A', 'B' -> {
                    for ((s, cnt) in map) {
                        put(s + S[i - 1], cnt)
                    }
                }

                else -> {
                    for ((s, cnt) in map) {
                        put(s + 'A', cnt)
                        put(s + 'B', cnt)
                    }
                }
            }
        }.filterNot { (s, _) -> range(K / 2).all { s[it] == s[K - 1 - it] } }

        map = buildMap {
            tmp.forEach { (s, cnt) ->
                put(s.substring(1), getOrDefault(s.substring(1), 0L).plusMod(cnt, MOD))
            }
        }
    }

    println(map.values.sumMod(MOD))
}
