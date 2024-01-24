package com.github.ked4ma.atcoder.abc173

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    var ac = 0
    var wa = 0
    var tle = 0
    var re = 0
    repeat(nextInt()) {
        when (next()) {
            "AC" -> ac++
            "WA" -> wa++
            "TLE" -> tle++
            "RE" -> re++
        }
    }
    println("AC x $ac")
    println("WA x $wa")
    println("TLE x $tle")
    println("RE x $re")
}
