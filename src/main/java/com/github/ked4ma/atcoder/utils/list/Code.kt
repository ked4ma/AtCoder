package com.github.ked4ma.atcoder.utils.list

// ## List
/**
 * this is copy of Iterator<>.scanReduce because of its experimentation stage
 */
private inline fun <T : Number, R : T> List<R>.cumulative(operation: (acc: T, l: R) -> T): List<T> {
    val iterator = this.iterator()
    if (!iterator.hasNext()) return emptyList()
    var accumulator: T = iterator.next()
    val result = ArrayList<T>(size).apply { add(accumulator) }
    while (iterator.hasNext()) {
        accumulator = operation(accumulator, iterator.next())
        result.add(accumulator)
    }
    return result
}

fun List<Long>.cumulativeSum(): List<Long> = (listOf(0L) + this).cumulative { acc, l -> acc + l }

