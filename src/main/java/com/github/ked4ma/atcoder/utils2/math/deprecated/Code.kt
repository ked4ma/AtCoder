package com.github.ked4ma.atcoder.utils2.math.deprecated

@Deprecated(
    message = "Recommend to use `gcd(x: Long, y: Long)`",
    replaceWith = ReplaceWith(
        "gcd(x, y)",
        "com.github.ked4ma.atcoder.utils.math.gcd.*",
    ),
)
fun gcd(x: Int, y: Int): Int {
    fun innerGcd(x: Int, y: Int): Int {
        return if (x % y == 0) y else innerGcd(y, x % y)
    }
    return if (x >= y) innerGcd(x, y) else innerGcd(y, x)
}

@Deprecated(
    message = "Recommend to use `Long.pow(n: Long)` with consideration for overflows",
    replaceWith = ReplaceWith(
        "this.pow(n)",
        "com.github.ked4ma.atcoder.utils.math.*",
    ),
)
fun Int.pow(n: Int): Int {
    if (n < 0) throw IllegalArgumentException("n($n) must be greater than or equal to zero(0).")
    var res = 1
    repeat(n) {
        res *= this
    }
    return res
}

@Deprecated(
    message = "Recommend to use `Long.pow(n: Long)` with consideration for overflows",
    replaceWith = ReplaceWith(
        "this.pow(n)",
        "com.github.ked4ma.atcoder.utils.math.*",
    ),
)
fun Long.pow(n: Int): Long {
    if (n < 0) throw IllegalArgumentException("n($n) must be greater than or equal to zero(0).")
    var res = 1L
    repeat(n) {
        res *= this
    }
    return res
}
