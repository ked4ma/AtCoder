package com.github.khronos227.atcoder.utils

import java.io.BufferedReader // # _debug_

/**
 * ----------
 * Utils
 * ----------
 */
// ## Input
fun next() = readLine()!!
fun nextInt() = next().toInt()
fun nextLong() = next().toLong()
fun nextDouble() = next().toDouble()
fun nextList() = next().split(" ")
fun nextIntList() = nextList().map(String::toInt)
fun nextLongList() = nextList().map(String::toLong)
fun nextDoubleList() = nextList().map(String::toDouble)

// ## Input (with BufferedReader)
fun next(br: BufferedReader) = br.readLine()!!
fun nextInt(br: BufferedReader) = next(br).toInt()
fun nextLong(br: BufferedReader) = next(br).toLong()
fun nextDouble(br: BufferedReader) = next(br).toDouble()
fun nextList(br: BufferedReader) = next(br).split(" ")
fun nextIntList(br: BufferedReader) = nextList(br).map(String::toInt)
fun nextLongList(br: BufferedReader) = nextList(br).map(String::toLong)
fun nextDoubleList(br: BufferedReader) = nextList(br).map(String::toDouble)

// ## Array
inline fun <reified T> sizedArray(size: Int, default: T) = Array(size) { default }
inline fun <reified T> sized2DArray(row: Int, column: Int, default: T) = Array(row) { Array(column) { default } }

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

// ## mod^-1
//    [NOTE] CANNOT use this for 0, mod, 2mod, 3mod ...(return wrong value)
fun modinv(num: Long, mod: Long): Long {
    var a = num
    var b = mod
    var u = 1L
    var v = 0L
    while (b > 0) {
        val t = a.div(b)
        a -= t * b
        a = b.also { b = a } // swap a and b
        u -= t * v
        u = v.also { v = u } // swap u and v
    }
    u %= mod
    if (u < 0) u += mod
    return u
}

fun modinv2(a: Long, b: Long, x: Long, y: Long): Triple<Long, Long, Long> {
    if (b == 0L) {
        return Triple(a, 1, 0)
    }
    val (d, y2, x2) = modinv2(b, a % b, y, x)
    return Triple(d, x2, y2 - a / b * x2)
}

// calc "x!"
fun factorial(x: Int): Long {
    if (x < 0) throw RuntimeException("this need positive param")
    var res = 1L
    var i = 2
    while (i <= x) {
        res *= i
        i++
    }
    return res
}

const val MOD = 1_000_000_007L
fun Long.plusMod(n: Long, mod: Long = MOD) = this.plus(n, mod)
fun Long.minusMod(n: Long, mod: Long = MOD) = this.minus(n, mod)
fun Long.timesMod(n: Long, mod: Long = MOD) = this.times(n, mod)
fun Long.divMod(n: Long, mod: Long = MOD) = this.div(n, mod)
fun Long.plus(n: Long, mod: Long) = (this + n) % mod
fun Long.minus(n: Long, mod: Long) = (this - n + mod) % mod
fun Long.times(n: Long, mod: Long) = (this * n) % mod
fun Long.div(n: Long, mod: Long) = this * modinv(n, mod)

// gcd
fun gcd(x: Int, y: Int): Int {
    fun innerGcd(x: Int, y: Int): Int {
        return if (x % y == 0) y else innerGcd(y, x % y)
    }
    return if (x >= y) innerGcd(x, y) else innerGcd(y, x)
}

fun gcd(x: Long, y: Long): Long {
    fun innerGcd(x: Long, y: Long): Long {
        return if (x % y == 0L) y else innerGcd(y, x % y)
    }
    return if (x >= y) innerGcd(x, y) else innerGcd(y, x)
}

// classes
class UnionFind(val size: Int) {
    private val r = sizedArray(size, -1)
    fun root(x: Int): Int {
        if (r[x] < 0) return x
        return root(r[x])
    }

    val roots: Array<Int> get() = (r.indices).map { root(it) }.toTypedArray()

    fun unite(x: Int, y: Int) {
        var rx = root(x)
        var ry = root(y)
        if (rx == ry) return
        if (r[rx] > r[ry]) {
            rx = ry.also { ry = rx }
        }
        r[rx] += r[ry]
        r[ry] = rx
    }

    fun size(x: Int) = -r[root(x)]
    val categories: List<Int>
        get() = r.indices.map { root(it) }

    override fun toString(): String {
        return r.joinToString(separator = ", ")
    }
}

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
            return sizedArray(2 * n - 1, initValue).also {
                // set list value to array
                list.forEachIndexed { i, v ->
                    it[i + n - 1] = v
                }
            }.let {
                newInstance(it, n, operator)
            }
        }

        fun <T> newInstance(innerArr: Array<T>, n: Int, operator: (T, T) -> T) = SegmentTree(innerArr, n, operator)
    }
}

// https://qiita.com/R_olldIce/items/f2f7930e7f67963f0493
// http://hos.ac/slides/20140319_bit.pdf
// Also Called BIT (binary indexed tree)
class FenwickTree(private val size: Int) {
    private val arr = sizedArray(size, 0L)

    fun add(index: Int, value: Long) {
        if (index !in 0 until size) throw IllegalArgumentException("index must be in range [0,$this)")
        var i = index + 1
        while (i <= size) {
            arr[i - 1] += value
            i += i and -i
        }
    }

    private fun sum(right: Int): Long {
        var ans = 0L
        var r = right
        while (r > 0) {
            ans += arr[r - 1]
            r -= r and -r
        }
        return ans
    }

    fun sum(left: Int, right: Int): Long {
        if (left < 0 || size < right || right < left) {
            throw IllegalArgumentException("need: 0 <= left <= right <= $size")
        }
        return sum(right) - sum(left)
    }
}
