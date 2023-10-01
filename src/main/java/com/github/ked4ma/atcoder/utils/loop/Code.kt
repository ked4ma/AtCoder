package com.github.ked4ma.atcoder.utils.loop

// repeat
inline fun <T> times(num: Int, block: (Int) -> T) = (0 until num).map {
    block.invoke(it)
}
