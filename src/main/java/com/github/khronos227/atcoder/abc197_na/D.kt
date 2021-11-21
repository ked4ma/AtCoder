package com.github.khronos227.atcoder.abc197_na

import com.github.khronos227.atcoder.utils.*
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    val N = nextInt()
    val (x0, y0) = nextDoubleList()
    val (xn, yn) = nextDoubleList()
    val (xc, yc) = (x0 + xn) / 2 to (y0 + yn) / 2

    val theta = 2 * PI / N
    val rot = arrayOf(
        arrayOf(cos(theta), -sin(theta)),
        arrayOf(sin(theta), cos(theta))
    )

    (x0 - xc to y0 - yc).let { (x, y) ->
        _debug_println("$x, $y")
        x * rot[0][0] + y * rot[0][1] to x * rot[1][0] + y * rot[1][1]
    }.let { (x, y) ->
        _debug_println("$x, $y")
        x + xc to y + yc
    }.let { (x, y) ->
        println("$x $y")
    }
}
