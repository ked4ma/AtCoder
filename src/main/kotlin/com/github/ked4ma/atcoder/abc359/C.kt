package com.github.ked4ma.atcoder.abc359

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.abs
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (Sx, Sy) = nextLongList()
    val (Tx, Ty) = nextLongList()
    val diffX = abs(Tx - Sx)
    val diffY = abs(Ty - Sy)
    val l: Long
    val r: Long
    if ((Sx + Sy) % 2 == 0L) {
        l = Sx - diffY
        r = Sx + 1 + diffY
    } else {
        l = Sx - 1 - diffY
        r = Sx + diffY
    }
    _debug_println("$l $r")
    if (Tx in l..r) {
        println(diffY)
        return
    }
    val lIdx = if (Ty % 2 == 0L) {
        l / 2
    } else {
        (l + 1) / 2
    }
    val rIdx = if (Ty % 2 == 0L) {
        r / 2
    } else {
        (r + 1) / 2
    }
    val tIdx = if (Ty % 2 == 0L) {
        Tx / 2
    } else {
        (Tx + 1) / 2
    }
    _debug_println(tIdx)
    println(diffY + min(abs(tIdx - lIdx), abs(tIdx - rIdx)))
}
