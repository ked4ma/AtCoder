package com.github.ked4ma.atcoder.abc051_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val (sx, sy, tx, ty) = nextIntList()
    var res = ""
    // start with y axis, cuz sample answer started with it.
    // (sx, sy) -> (sx, ty)
    repeat(ty - sy) {
        res += "U"
    }
    // (sx, ty) -> (tx, ty)
    repeat(tx - sx) {
        res += "R"
    }
    // (tx, ty) -> (tx, sy)
    repeat(ty - sy) {
        res += "D"
    }
    // (tx, sy) -> (sx - 1, sy)
    repeat(tx - sx + 1) {
        res += "L"
    }
    // 2round
    // (sx - 1, sy) -> (sx - 1, ty + 1)
    repeat(ty - sy + 1) {
        res += "U"
    }
    // (sx - 1, ty + 1) -> (tx, ty + 1)
    repeat(tx - sx + 1) {
        res += "R"
    }
    //  (tx, ty + 1) -> (tx, ty) -> (tx + 1, ty)
    res += "DR"
    // (tx + 1, ty) -> (tx + 1, sy - 1)
    repeat(ty - sy + 1) {
        res += "D"
    }
    // (tx + 1, sy - 1) -> (sx , sy - 1)
    repeat(tx - sx + 1) {
        res += "L"
    }
    // (sx, sy - 1) -> (sx, sy)
    res += "U"
    println(res)
}
