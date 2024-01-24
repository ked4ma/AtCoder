package com.github.ked4ma.atcoder.abc337

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.number.long.bit.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    var b = 0
    while (1L shl b < N) b++
    println(b)

    repeat(b) { i ->
        buildList {
            loop(N) { j ->
                if (j.bit(i)) add(j + 1)
            }
        }.let {
            println("${it.size} ${it.joinToString(" ")}")
        }
    }

    val S = next().toCharArray()
    var ans = 0L
    S.forEachIndexed { i, c ->
        if (c == '1') ans = ans or (1L shl i)
    }
    println(ans + 1)
}
//fun main() {
//    val N = nextLong()
//    var k = 2L
//    var n = 1L
//    while (k < N) {
//        k *= 2
//        n++
//    }
//    println(n)
//    var tmpK = k / 2
//    val people = sized2DBooleanArray(n, N, false)
//    loop(n) { i ->
//        loop(N) { j ->
//            people[i][j] = (j / tmpK) % 2 == 1L
//        }
//        tmpK /= 2
//    }
//    people.forEach { arr ->
//        val sj = StringJoiner(" ")
//        sj.add(arr.filter { it }.size.toString())
//        loop(N) { i ->
//            if (arr[i]) sj.add((i + 1).toString())
//        }
//        println(sj)
//    }
//
//    val res = next().toCharArray()
//    _debug_println(res.joinToString(","))
//    var l = 0L
//    var r = k
//    res.forEach { c ->
//        val mid = (l + r) / 2
//        if (c == '0') {
//            r = mid
//        } else {
//            l = mid
//        }
//    }
//    println(l + 1)
//}