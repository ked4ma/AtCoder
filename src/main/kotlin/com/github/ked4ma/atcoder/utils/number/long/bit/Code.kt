package com.github.ked4ma.atcoder.utils.number.long.bit

infix fun Long.bit(i: Int) = (this shr i) and 1L == 1L

/**
 * get bit length to represent number.
 * e.g.
 *   4: 0x100 = 3
 *   5: 0x101 = 3
 *   1: 0x1 = 1
 */
fun Long.bitLength(): Int {
    if (this == 0L) return 0
    var n = this
    var len = 0
    while (n != 0L) {
        n = n ushr 1
        len++
    }
    return len
}
