package com.github.ked4ma.atcoder.utils.number.long.bit

infix fun Long.shl(n: Long) = this shl n.toInt()
infix fun Long.shr(n: Long) = this shr n.toInt()
infix fun Long.bit(i: Long) = (this shr i) and 1L == 1L