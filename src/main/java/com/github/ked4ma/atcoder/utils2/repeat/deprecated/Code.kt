package com.github.ked4ma.atcoder.utils2.repeat.deprecated

@Deprecated(
    message = "Recommend to use `times(num: Long, block: (Long) -> T)` with consideration for overflows",
    replaceWith = ReplaceWith(
        "times(num, block)",
        "com.github.ked4ma.atcoder.utils.loop.default.*",
    ),
)
inline fun <T> times(num: Int, block: (Int) -> T) = (0 until num).map {
    block.invoke(it)
}
