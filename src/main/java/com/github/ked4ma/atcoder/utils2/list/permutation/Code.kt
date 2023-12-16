package com.github.ked4ma.atcoder.utils2.list.permutation

// get all permutations
// e.g. [1,2,3],size:2 -> [1,2],[1,3],[2,1],[2,3],[3,1],[3,2]
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
