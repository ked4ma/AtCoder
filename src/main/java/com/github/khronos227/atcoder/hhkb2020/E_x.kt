package com.github.khronos227.atcoder.hhkb2020

fun main() {
    val mod = 1_000_000_007L
    fun Long.timesMod(x: Long) = this.times(x).rem(mod)
    fun Long.divMod(x: Long) = this.times(modinv(x, mod)).rem(mod)
    fun Long.plusMod(x: Long) = this.plus(x).rem(mod)
    fun Long.minusMod(x: Long) = this.plus(mod).minus(x).rem(mod)

    val (h, w) = nextIntList()
    val map = (0 until h).map {
        next()
    }
    val k = map.sumBy { m -> m.count { it == '.' } }
    var base = 1L
    repeat(k) {
        base = base.timesMod(2)
    }
    var total = k.toLong().timesMod(base)
    val countHArr = sized2DArray(h, w, 0)
    (0 until w).forEach { j ->
        var i = 0
        var count = 0
        while (i < h) {
            if (map[i][j] == '#') {
                repeat(count) {
                    countHArr[i - it - 1][j] = count
                }
                count = 0
            } else {
                count++
            }
            i++
        }
        repeat(count) {
            countHArr[i - it - 1][j] = count
        }
    }
    val countWArr = sized2DArray(h, w, 0)
    (0 until h).forEach { i ->
        var j = 0
        var count = 0
        while (j < w) {
            if (map[i][j] == '#') {
                repeat(count) {
                    countWArr[i][j - it - 1] = count
                }
                count = 0
            } else {
                count++
            }
            j++
        }
        repeat(count) {
            countWArr[i][j - it - 1] = count
        }
    }

    val valueMap = mutableMapOf<Int, Long>()
    (0 until h).forEach { i ->
        (0 until w).forEach { j ->
            if (map[i][j] == '#') return@forEach
            val t = countHArr[i][j] + countWArr[i][j] - 1

            if (t !in valueMap) {
                var subtotal = base
                repeat(t) {
                    subtotal = subtotal.divMod(2)
                }
                valueMap[t] = subtotal
            }
            total = total.minusMod(valueMap.getValue(t))
        }
    }
    println(total)
}

// # Utils
// ## Input
fun next() = readLine()!!
fun nextInt() = next().toInt()
fun nextLong() = next().toLong()
fun nextDouble() = next().toDouble()
fun nextList() = next().split(" ")
fun nextIntList() = next().split(" ").map(String::toInt)
fun nextLongList() = next().split(" ").map(String::toLong)
fun nextDoubleList() = next().split(" ").map(String::toDouble)

// ## Array
inline fun <reified T> sizedArray(size: Int, default: T) = Array(size) { default }
inline fun <reified T> sized2DArray(row: Int, column: Int, default: T) = Array(row) { Array(column) { default } }

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
class UnionFindTree(val size: Int) {
    private val r = sizedArray(size, -1)
    fun root(x: Int): Int {
        if (r[x] < 0) return x
        return root(r[x])
    }

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