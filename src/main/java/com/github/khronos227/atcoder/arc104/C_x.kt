package com.github.khronos227.atcoder.arc104

fun main() {
    val n = nextInt()
    val aList = sizedArray(n, 0)
    val bList = sizedArray(n, 0)
    val tp = sizedArray(n * 2, 0)
    val com = sizedArray(n * 2, -1)

    var ng = false
    repeat(n) { i ->
        val (a, b) = nextIntList()
        aList[i] = a
        bList[i] = b
        if (aList[i] != -1) {
            aList[i] = a - 1
            if (tp[aList[i]] != 0) ng = true
            tp[aList[i]] = i + 1
        }
        if (bList[i] != -1) {
            bList[i] = b - 1
            if (tp[bList[i]] != 0) ng = true
            tp[bList[i]] = -(i + 1)
        }
        if (aList[i] != -1 && bList[i] != -1) {
            com[aList[i]] = bList[i]
            com[bList[i]] = aList[i]
        }
    }

    if (ng) {
        println("No")
        return
    }

    val dp = sizedArray(n * 2 + 1, false)
    dp[0] = true

    repeat(n * 2) { i ->
        if (!dp[i]) return@repeat

        ((i + 1) until n * 2).forEach { j ->
            var w = j - i + 1
            if (w % 2 != 0) return@forEach // area size must be 2x
            w /= 2
            var ok = true
            val exist = sizedArray(n, false)

            repeat(w) { k ->
                val p = i + k
                val q = i + k + w
                if (com[p] != -1 && com[p] !in i..j) {
                    ok = false
                }
                if (com[q] != -1 && com[q] !in i..j) {
                    ok = false
                }

                var same = false
                if (tp[p] != 0 && tp[q] != 0) {
                    if (tp[p] < 0 || tp[p] + tp[q] != 0) {
                        ok = false
                    } else {
                        same = true
                    }
                }
                if (tp[p] < 0 || tp[q] > 0) {
                    ok = false
                } else {
                    if (tp[p] != 0) {
                        val v = tp[p] - 1
                        if (exist[v]) {
                            ok = false
                        }
                        exist[v] = true
                    }
                    if (!same && tp[q] != 0) {
                        val v = -tp[q] - 1
                        if (exist[v]) {
                            ok = false
                        }
                        exist[v] = true
                    }
                }
            }
            if (ok) {
                dp[j + 1] = true
            }
        }
    }
//    println(dp.joinToString(separator = ","))
    println(if (dp[n * 2]) "Yes" else "No")
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

    override fun toString(): String {
        return r.joinToString(separator = ", ")
    }
}