package com.github.khronos227.atcoder.abc173

import com.github.khronos227.atcoder.utils.*
import kotlin.math.absoluteValue

private const val MOD = 1_000_000_007

fun main() {
    val (n, k) = nextIntList()

    if (n == k) {
        println(nextLongList().stream().map { it.plus(MOD).rem(MOD) }.reduce { acc, l -> acc.times(l).rem(MOD) })
        return
    }

    val nums = nextLongList().groupBy { it >= 0 }.mapValues { (_, value) ->
        value.sortedByDescending { it.absoluteValue }
    }
    val positives = nums.getOrDefault(true, emptyList())
    val negatives = nums.getOrDefault(false, emptyList())

    if (positives.isEmpty() && k % 2 == 1) {
        println(negatives.stream().map { it.plus(MOD).rem(MOD) }.reduce { acc, l -> acc.times(l).rem(MOD) })
        return
    }

    var posIndex = 0
    var negIndex = 0
    val res = mutableListOf<Long>()
    while (res.size < k) {
        when {
            res.size == k - 1 -> {
                res.add(positives[posIndex])
                posIndex++
            }
            negIndex >= negatives.lastIndex -> {
                res.add(positives[posIndex])
                posIndex++
            }
            posIndex >= positives.lastIndex -> {
                res.add(negatives[negIndex])
                res.add(negatives[negIndex + 1])
                negIndex += 2
            }
            positives[posIndex] * positives[posIndex + 1] > negatives[negIndex] * negatives[negIndex + 1] -> {
                res.add(positives[posIndex])
                posIndex++
            }
            else -> {
                res.add(negatives[negIndex])
                res.add(negatives[negIndex + 1])
                negIndex += 2
            }
        }
    }
    println(res.stream().map { it.plus(MOD).rem(MOD) }.reduce { acc, l -> acc.times(l).rem(MOD) }.get())
}
