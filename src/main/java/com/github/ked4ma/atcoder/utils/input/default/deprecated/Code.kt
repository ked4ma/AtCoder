package com.github.ked4ma.atcoder.utils.input.default.deprecated

import com.github.ked4ma.atcoder.utils.input.default.*

@Deprecated(
    message = "Recommend using `nextLong()` with consideration for overflows",
    replaceWith = ReplaceWith(
        "nextLong()",
        "com.github.ked4ma.atcoder.utils.input.default.*",
    ),
)
fun nextInt() = next().toInt()

@Deprecated(
    message = "Recommend using `nextLongList()` with consideration for overflows",
    replaceWith = ReplaceWith(
        "nextLongList()",
        "com.github.ked4ma.atcoder.utils.input.default.*",
    ),
)
fun nextIntList() = nextList().map(String::toInt)
