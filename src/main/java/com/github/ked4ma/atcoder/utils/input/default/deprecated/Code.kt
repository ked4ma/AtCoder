package com.github.ked4ma.atcoder.utils.input.default.deprecated

@Deprecated(
    message = "Recommend to use `nextLong()` with consideration for overflows",
    replaceWith = ReplaceWith(
        "nextLong()",
        "com.github.ked4ma.atcoder.utils.input.default.*",
    ),
)
fun nextInt() = readln().toInt()

@Deprecated(
    message = "Recommend to use `nextLongList()` with consideration for overflows",
    replaceWith = ReplaceWith(
        "nextLongList()",
        "com.github.ked4ma.atcoder.utils.input.default.*",
    ),
)
fun nextIntList() = readln().split(" ").map(String::toInt)
