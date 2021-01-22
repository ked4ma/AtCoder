package com.github.khronos227.atcoder.abc188

import com.github.khronos227.atcoder.utils.*
import kotlin.math.abs

fun main() {
    val (A, B) = nextIntList()
    println(if (abs(A - B) < 3) "Yes" else "No")
}
