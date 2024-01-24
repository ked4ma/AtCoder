package com.github.ked4ma.atcoder.utils.models.tree.segment

// https://tsutaj.hatenablog.com/entry/2017/03/29/204841
class SegmentTree<T> private constructor(
    private val arr: Array<T>,
    private val n: Int,
    private val operator: (T, T) -> T
) {
    init {
        for (i in n - 2 downTo 0) {
            arr[i] = operator(arr[2 * i + 1], arr[2 * i + 2])
        }
    }

    fun update(index: Int, updater: (T) -> T) {
        var i = index + n - 1
        arr[i] = updater(arr[i])
        while (i > 0) {
            i = (i - 1) / 2
            arr[i] = operator(arr[2 * i + 1], arr[2 * i + 2])
        }
    }

    /**
     * @param a target left (inclusive)
     * @param b target right (exclusive)
     * @param k current node index
     * @param l current target left
     * @param r current target right
     */
    fun get(a: Int, b: Int, k: Int = 0, l: Int = 0, r: Int = n): T {
        if (r <= a || b <= l) throw IllegalArgumentException("[a($a),b($b)) must be in [l($l),r($r)). k:$k")
        if (a <= l && r <= b) return arr[k]
        val mid = (l + r) / 2
        return when {
            b <= mid -> get(a, b, 2 * k + 1, l, mid)
            mid <= a -> get(a, b, 2 * k + 2, mid, r)
            else -> {
                operator(
                    get(a, b, 2 * k + 1, l, mid),
                    get(a, b, 2 * k + 2, mid, r)
                )
            }
        }
    }

    override fun toString(): String {
        return "SegmentTree[${arr.joinToString(", ")}]"
    }

    companion object {
        inline fun <reified T> of(list: List<T>, initValue: T, noinline operator: (a: T, b: T) -> T): SegmentTree<T> {
            if (list.isEmpty()) {
                throw IllegalArgumentException("list parameter size must not be 0")
            }
            var n = 1
            while (n < list.size) {
                n *= 2
            }
            return Array(2 * n - 1) { initValue }.also {
                // set list value to array
                list.forEachIndexed { i, v ->
                    it[i + n - 1] = v
                }
            }.let {
                newInstance(it, n, operator)
            }
        }

        inline fun <reified T> of(size: Int, initValue: T, noinline operator: (a: T, b: T) -> T): SegmentTree<T> {
            var n = 1
            while (n < size) {
                n *= 2
            }
            return newInstance(Array(2 * n - 1) { initValue }, n, operator)
        }

        fun <T> newInstance(innerArr: Array<T>, n: Int, operator: (T, T) -> T) = SegmentTree(innerArr, n, operator)
    }
}
