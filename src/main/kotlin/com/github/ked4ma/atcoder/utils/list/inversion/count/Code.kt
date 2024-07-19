package com.github.ked4ma.atcoder.utils.list.inversion.count

import com.github.ked4ma.atcoder.utils.list.dim.compress.*
import com.github.ked4ma.atcoder.utils.models.tree.fenwick.*

// calc inversion count of List
// https://scrapbox.io/pocala-kyopro/%E8%BB%A2%E5%80%92%E6%95%B0
fun List<Int>.inversionCount(): Long {
    val data = this.compress()
    var count = 0L
    val ft = FenwickTree(data.toSet().size)
    for (n in data) {
        count += ft.sum(n + 1)
        ft.add(n, 1)
    }
    return count
}