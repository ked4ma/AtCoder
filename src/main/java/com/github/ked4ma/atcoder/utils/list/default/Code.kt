package com.github.ked4ma.atcoder.utils.list.default

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

fun <T> List<T>.combinations(size: Int, allowRepetition: Boolean = false): Sequence<List<T>> {
    if (size == 0) return sequenceOf(emptyList())
    if (this.isEmpty()) return emptySequence()

    val head = this.first()
    val withoutHead = this.drop(1)

    val combsWithHead =
        (if (allowRepetition) this else withoutHead).combinations(size - 1, allowRepetition).map { listOf(head) + it }
    val combsWithoutHead = withoutHead.combinations(size, allowRepetition)

    return combsWithHead + combsWithoutHead
}

fun <T> List<T>.permutations(size: Int, allowRepetition: Boolean = false): Sequence<List<T>> {
    if (size == 0) return sequenceOf(emptyList())

    return this.asSequence().flatMap { item ->
        val list = if (allowRepetition) {
            this
        } else {
            this - item
        }
        list.permutations(size - 1, allowRepetition).map { listOf(item) + it }
    }
}
