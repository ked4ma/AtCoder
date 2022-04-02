package com.github.ked4ma.atcoder.abc198_na

import kotlin.math.pow
import com.github.ked4ma.atcoder.utils.*

private fun toVal(s: CharArray, mapping: Map<Char, Int>): Long {
    return s.reversed().foldIndexed(0L) { i, acc, c ->
        acc + (mapping.getValue(c) * 10.0.pow(i).toLong())
    }
}

private fun solve(
    s1: CharArray,
    s2: CharArray,
    s3: CharArray,
    uniqChars: CharArray = (s1 + s2 + s3).toSet().toCharArray(),
    used: MutableSet<Int> = mutableSetOf(),
    mapping: MutableMap<Char, Int> = mutableMapOf()
): Triple<Long, Long, Long>? {
    if (uniqChars.size == used.size) {
        val n1 = toVal(s1, mapping)
        val n2 = toVal(s2, mapping)
        val n3 = toVal(s3, mapping)
        return if (n1 + n2 == n3 && n1 > 0 && n2 > 0 && n3 > 0) {
            Triple(n1, n2, n3)
        } else {
            null
        }
    }
    for (i in 0 until 10) {
        if (i in used) continue
        val c = uniqChars[used.size]
        if (i == 0 && (s1.first() == c || s2.first() == c || s3.first() == c)) continue
        mapping[c] = i
        used.add(i)
        val res = solve(s1, s2, s3, uniqChars, used, mapping)
        if (res != null) {
            return res
        }
        mapping.remove(c)
        used.remove(i)
    }
    return null
}

fun main() {
    val s1 = next().toCharArray()
    val s2 = next().toCharArray()
    val s3 = next().toCharArray()

    if ((s1 + s2 + s3).toSet().size > 10) {
        println("UNSOLVABLE")
        return
    }

    val res = solve(s1, s2, s3)
    if (res == null) {
        println("UNSOLVABLE")
    } else {
        println(res.first)
        println(res.second)
        println(res.third)
    }
}
