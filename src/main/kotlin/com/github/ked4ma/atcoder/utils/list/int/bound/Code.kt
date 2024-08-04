package com.github.ked4ma.atcoder.utils.list.int.bound

/**
 * ref: https://webbibouroku.com/Blog/Article/cs-lowerbound-upperbound
 */
fun List<Int>.lowerBound(v: Int): Int {
    var l = 0
    var r = this.lastIndex
    while (l <= r) {
        val m = (l + r) / 2
        if (this[m] < v) {
            l = m + 1
        } else {
            r = m - 1
        }
    }
    return l
}

/**
 * ref: https://webbibouroku.com/Blog/Article/cs-lowerbound-upperbound
 */
fun List<Int>.upperBound(v: Int): Int {
    var l = 0
    var r = this.lastIndex
    while (l <= r) {
        val m = (l + r) / 2
        if (this[m] <= v) {
            l = m + 1
        } else {
            r = m - 1
        }
    }
    return l
}
