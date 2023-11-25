package com.github.ked4ma.atcoder.utils.array.deprecated

@Deprecated(
    message = "Recommend using `sizedArray(size: Long, default: () -> T)`",
    replaceWith = ReplaceWith(
        "sizedArray(size, default)",
        "com.github.ked4ma.atcoder.utils.array.*",
    ),
)
inline fun <reified T> sizedArray(size: Int, default: T) = Array(size) { default }

@Deprecated(
    message = "Recommend using `sizedArray(size: Long, default: () -> T)`",
    replaceWith = ReplaceWith(
        "sizedArray(size, default)",
        "com.github.ked4ma.atcoder.utils.array.*",
    ),
)
inline fun <reified T> sizedArray(size: Int, default: () -> T) = Array(size) { default.invoke() }

@Deprecated(
    message = "Recommend using `sizedArray(row: Long, col: Long, default: T)`",
    replaceWith = ReplaceWith(
        "sizedArray(row, column, default)",
        "com.github.ked4ma.atcoder.utils.array.*",
    ),
)
inline fun <reified T> sized2DArray(row: Int, column: Int, default: T) = Array(row) { Array(column) { default } }

@Deprecated(
    message = "Recommend using `sizedArray(row: Long, col: Long, default: T)`",
    replaceWith = ReplaceWith(
        "sizedArray(row, column, default)",
        "com.github.ked4ma.atcoder.utils.array.*",
    ),
)
inline fun <reified T> sized2DArray(row: Int, column: Int, default: () -> T) =
    Array(row) { Array(column) { default.invoke() } }