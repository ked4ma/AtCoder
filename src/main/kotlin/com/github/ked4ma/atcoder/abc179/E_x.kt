package com.github.ked4ma.atcoder.abc179

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.min

fun main() {
    val (n, x, m) = nextLongList()
    var a = x
    var loopSum = a
    val loopSet = linkedSetOf(a)
    var loopIndex = 0
    var i = 1
    while (i < m) {
        a = a.times(a).rem(m)
        if (a in loopSet) {
            loopIndex = loopSet.indexOf(a)
            break
        }
        loopSum += a
        loopSet.add(a)
        i++
    }
    var sum = 0L
    val loopList = loopSet.toList()
    repeat(min(n, loopIndex.toLong()).toInt()) {
        loopList.toList()
        sum += loopList[it]
    }
    n.minus(loopIndex).takeIf { it > 0 }?.let {
        val loop = it / (loopList.size - loopIndex)
        sum += loopSum.minus(sum).times(loop)
        repeat(it.rem((loopList.size - loopIndex)).toInt()) { index ->
            sum += loopList[loopIndex + index]
        }
    }
    println(sum)
}
