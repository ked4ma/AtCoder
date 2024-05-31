package com.github.ked4ma.atcoder.utils.number.int.bit

infix fun Int.bit(i: Int) = (this shr i) and 1 == 1

/**
 * get bit length to represent number.
 * e.g.
 *   4: 0x100 = 3
 *   5: 0x101 = 3
 *   1: 0x1 = 1
 */
fun Int.bitLength(): Int {
    if (this == 0) return 0
    var n = this
    var len = 0
    while (n != 0) {
        n = n ushr 1
        len++
    }
    return len
}