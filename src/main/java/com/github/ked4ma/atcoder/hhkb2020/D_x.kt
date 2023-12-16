package com.github.ked4ma.atcoder.hhkb2020

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*
import com.github.ked4ma.atcoder.utils.math.mod.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    fun calc(n: Long, a: Long, b: Long) {
        // (空白)(赤)(空白)(青)(空白) のパターン ※赤と青がかぶらない
        val x4 = if (n - a - b < 0) 0 else (n - a - b + 2).timesMod(n - a - b + 1).divMod(2)
        // 対称性より、赤と青がかぶらないパターンは
        val x3 = x4.timesMod(2)
        // 赤と青の全並べ方から、かぶらないパターンを引く ※赤と青がかぶるパターン数
        val x2 = (n - a + 1).timesMod(n - b + 1).minusMod(x3)
        // 赤と青が重なる並べ方(x軸,y軸両方とも加味)
        val x1 = x2.timesMod(x2)
        val ans = (n - a + 1).timesMod(n - a + 1).timesMod((n - b + 1).timesMod(n - b + 1)).minusMod(x1)
        println(ans)
    }
    // a >= b
//    fun calc(n: Long, a: Long, b: Long) {
//        val mn = n.minus(a - 1).let {
//            if (it % 2 == 0L) it / 2 else it / 2 + 1
//        }.toInt()
//        val arr = sized2DArray(mn, mn, 0L)
//        (1..mn).forEach { i ->
//            val up = i.minus(b - 1).coerceAtLeast(1)
//            val down = i.plus(a - 1).plus(b - 1).coerceAtMost(n)
//            val y = down - up + 1 - (b - 1)
//            (i..mn).forEach { j ->
//                val left = j.minus(b - 1).coerceAtLeast(1)
//                val right = j.plus(a - 1).plus(b - 1).coerceAtMost(n)
//                val x = right - left + 1 - (b - 1)
//                val value = y.times(x).rem(mod)
//                arr[i - 1][j - 1] = value
//                arr[j - 1][i - 1] = value
//            }
//        }
//        var count = 0L
//        arr.forEach { ar ->
//            ar.forEach { v ->
//                count = count.plus(v).rem(mod)
//            }
//        }
//        count = count.times(4).rem(mod)
//        if ((n % 2 == 0L) xor (a % 2 == 2L)) {
//            var c = 0L
//            (0 until mn).forEach {
//                c = (c + arr[it][mn - 1]).rem(mod)
//                c = (c + arr[mn - 1][it]).rem(mod)
//            }
//            c = (c.times(2) + mod - arr[mn - 1][mn - 1]).rem(mod)
//            count = (count - c + mod).rem(mod)
//        }
//        val la = n - (a - 1)
//        val lb = n - (b - 1)
//        println(((la.times(la).rem(mod).times(lb.times(lb).rem(mod))).rem(mod) + mod - count).rem(mod))
//    }

    repeat(nextInt()) {
        val (n, a, b) = nextLongList()
        calc(n, max(a, b), (min(a, b)))
    }
}
