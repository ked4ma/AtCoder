package com.github.ked4ma.atcoder.utils.list.cumlative

fun List<Long>.cumulativeSum(): List<Long> = this.scan(0L) { acc, l -> acc + l }