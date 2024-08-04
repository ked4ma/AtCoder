package com.github.ked4ma.atcoder.utils.string.runlength

fun String.runLengthEncoding() = buildList {
    val s = this@runLengthEncoding
    var cur = s[0]
    var cnt = 1
    for (i in 1 until s.length) {
        if (cur != s[i]) {
            add(cur to cnt)
            cur = s[i]
            cnt = 1
        } else {
            cnt++
        }
    }
    add(cur to cnt)
}