package com.github.ked4ma.atcoder.utils

/**
 * ----------
 * Utils
 * ----------
 */
// ## Input
fun next() = readln()
fun nextInt() = next().toInt()
fun nextLong() = next().toLong()
fun nextDouble() = next().toDouble()
fun nextList() = next().split(" ")
fun nextIntList() = nextList().map(String::toInt)
fun nextLongList() = nextList().map(String::toLong)
fun nextDoubleList() = nextList().map(String::toDouble)

// ## Input (with BufferedReader)
fun next(br: java.io.BufferedReader) = br.readLine()!!
fun nextInt(br: java.io.BufferedReader) = next(br).toInt()
fun nextLong(br: java.io.BufferedReader) = next(br).toLong()
fun nextDouble(br: java.io.BufferedReader) = next(br).toDouble()
fun nextList(br: java.io.BufferedReader) = next(br).split(" ")
fun nextIntList(br: java.io.BufferedReader) = nextList(br).map(String::toInt)
fun nextLongList(br: java.io.BufferedReader) = nextList(br).map(String::toLong)
fun nextDoubleList(br: java.io.BufferedReader) = nextList(br).map(String::toDouble)

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

// repeat
inline fun <T> times(num: Int, block: (Int) -> T) = (0 until num).map {
    block.invoke(it)
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
    if (x < 0) throw IllegalArgumentException("this need positive param")
    var res = 1L
    var i = 2
    while (i <= x) {
        res *= i
        i++
    }
    return res
}

fun combination(m: Int, n: Int): Long = combination(m, n, mutableMapOf()).first

fun combination(m: Int, n: Int, memo: MutableMap<Pair<Int, Int>, Long>): Pair<Long, Map<Pair<Int, Int>, Long>> {
    if (m < 0 || n < 0) throw IllegalArgumentException("m and n must be positive")
    if (m < n) throw IllegalArgumentException("m must be larger than n")

    fun comb(a: Int, b: Int): Long {
        if (b == 0 || a == b) return 1L
        if (b == 1) return a.toLong()
        val l = memo.getOrPut(a - 1 to b - 1) {
            comb(a - 1, b - 1)
        }
        val r = memo.getOrPut(a - 1 to b) {
            comb(a - 1, b)
        }
        return l + r
    }

    return comb(m, n) to memo
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

fun extGcd(a: Long, b: Long): Triple<Long, Long, Long> {
    fun logic(a: Long, b: Long, x: Long = 0L, y: Long = 0L): Triple<Long, Long, Long> {
        if (b == 0L) {
            return Triple(1L, 0L, a)
        }
        val (ny, nx, d) = logic(b, a % b, y, x)
        return Triple(nx, ny - ((a / b) * nx), d)
    }
    return logic(a, b)
}

// crt
/**
 * calc crt(Chinese Remainder Theorem) with extGcd.
 * solve [x≡b1(mod. m1), x≡b2(mod. m2),...] -> x≡r(mod. m)
 * @return r(mod. m)
 */
fun crt(b: List<Long>, m: List<Long>): Pair<Long, Long> {
    var r = 0L
    var M = 1L
    b.zip(m).forEach { (bi, mi) ->
        val (p, _, d) = extGcd(M, mi)
        if ((bi - r) % d != 0L) return 0L to -1L
        val tmp = (bi - r) / d * p % (mi / d)
        r += M * tmp
        M *= mi / d
    }
    return (r % M + M) % M to M
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

class CumulativeSum2D {
    private val h: Int
    private val w: Int
    private val data: Array<Array<Long>>

    /**
     * NOTE: only use for one time initialization.
     * If need to recreate several time, use set and build func.
     */
    constructor(arr: Array<Array<out Number>>) {
        h = arr.size
        w = arr.first().size
        data = sized2DArray(h + 1, w + 1, 0L)
        for (i in 0 until h) {
            for (j in 0 until w) {
                data[i + 1][j + 1] = data[i][j + 1] + data[i + 1][j] - data[i][j] + arr[i][j].toLong()
            }
        }
    }

    constructor(h: Int, w: Int) {
        this.h = h
        this.w = w
        data = sized2DArray(h + 1, w + 1, 0L)
    }

    fun set(h: Int, w: Int, n: Number) {
        data[h + 1][w + 1] = n.toLong()
    }

    fun build() {
        for (i in 0 until h) {
            for (j in 0 until w) {
                data[i + 1][j + 1] = data[i][j + 1] + data[i + 1][j] - data[i][j] + data[i + 1][j + 1]
            }
        }
    }

    fun getSumOf(startX: Int, startY: Int, endX: Int, endY: Int): Long =
        data[endY + 1][endX + 1] - data[endY + 1][startX] - data[startY][endX + 1] + data[startY][startX]
}
