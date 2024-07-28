package com.github.ked4ma.atcoder.utils.list.long.cumlative

fun List<Long>.cumulativeSum(): List<Long> = this.scan(0L) { acc, l -> acc + l }