package com.github.khronos227.atcoder.abc173

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
