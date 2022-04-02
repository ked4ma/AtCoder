package com.github.ked4ma.atcoder.abc042_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val mod = 1_000_000_007L
    val (h, w, a, b) = nextIntList()
    val factList = mutableListOf(1L)
    val modFactList = mutableListOf(modinv(1L, mod))

    var f = 1L
    (1..(h + w)).forEach {
        f = f.times(it).rem(mod)
        factList.add(f)
        modFactList.add(modinv(f, mod))
    }

    fun combi(i: Int, j: Int): Long {
        return factList[i + j].times(modFactList[i]).rem(mod).times(modFactList[j]).rem(mod)
    }

    val hn = h - a - 1
    var s = 0L
    (0 until b).forEach {
        s = s.plus(combi(hn, it).times(combi(a - 1, w - it - 1)).rem(mod)).rem(mod)
    }
    println(combi(h - 1, w - 1).minus(s).plus(mod).rem(mod))
}
