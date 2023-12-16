package com.github.ked4ma.atcoder.utils.list.combination

// get all combinations
// e.g. [1,2,3],size:2 -> [1,2],[1,3],[2,3]
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
