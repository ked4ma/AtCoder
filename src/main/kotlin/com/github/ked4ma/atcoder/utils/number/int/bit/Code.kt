package com.github.ked4ma.atcoder.utils.number.int.bit

infix fun Int.bit(i: Int) = (this shr i) and 1 == 1
