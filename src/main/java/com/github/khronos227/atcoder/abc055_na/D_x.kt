package com.github.khronos227.atcoder.abc055_na

fun main() {
    val n = nextInt()
    val s = next()
    for (start in arrayOf("SS", "SW", "WS", "WW")) {
        val line = start.toCharArray().toMutableList()
        (1..n).forEach { index ->
            val prev = line[index - 1]
            val curr = line[index % n]
            val si = s[index % n]
            when {
                curr == 'S' && prev == 'S' -> line.add(if (si == 'o') 'S' else 'W')
                curr == 'S' && prev == 'W' -> line.add(if (si == 'o') 'W' else 'S')
                curr == 'W' && prev == 'S' -> line.add(if (si == 'o') 'W' else 'S')
                curr == 'W' && prev == 'W' -> line.add(if (si == 'o') 'S' else 'W')
            }
        }
        // validate
        if (line[0] == line[n] && line[1] == line[n + 1]) {
            println(line.subList(0, n).joinToString(separator = ""))
            return
        }
    }
    println(-1)
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
        println("t: $t a: $a b: $b u: $u v: $v")
        a -= t * b
        a = b.also { b = a } // swap a and b
        u -= t * v
        u = v.also { v = u } // swap u and v
    }
    u %= mod
    println("$u $v")
    if (u < 0) u += mod
    return u
}

fun modinv2(a: Long, b: Long, x: Long, y: Long): Triple<Long, Long, Long> {
    if (b == 0L) {
        return Triple(a, 1, 0)
    }
    val (d, y2, x2) = modinv2(b, a % b, y, x)
    println("$d $x2 $y2 ${a / b}")
    return Triple(d, x2, y2 - a / b * x2)
}

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
class UnionFindTree(val size: Int) {
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

    fun main() {
        val n = nextInt()
        val s = next()
        var prev = 'S'
        var ans = "S"
        repeat(n - 1) {
            val curr = ans[it]
            val si = s[it]
            ans += when {
                curr == 'S' && prev == 'S' -> {
                    if (si == 'o') 'S' else 'W'
                }
                curr == 'S' && prev == 'W' -> {
                    if (si == 'o') 'W' else 'S'
                }
                curr == 'W' && prev == 'S' -> {
                    if (si == 'o') 'W' else 'S'
                }
                curr == 'W' && prev == 'W' -> {
                    if (si == 'o') 'S' else 'W'
                }
                else -> ""
            }
            prev = curr
        }
        if (ans.last() != 'S' || (s.last() == 'x' && ans[n - 3] != 'W')) {
            println(-1)
            return
        }

        println(ans)
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
            println("t: $t a: $a b: $b u: $u v: $v")
            a -= t * b
            a = b.also { b = a } // swap a and b
            u -= t * v
            u = v.also { v = u } // swap u and v
        }
        u %= mod
        println("$u $v")
        if (u < 0) u += mod
        return u
    }

    fun modinv2(a: Long, b: Long, x: Long, y: Long): Triple<Long, Long, Long> {
        if (b == 0L) {
            return Triple(a, 1, 0)
        }
        val (d, y2, x2) = modinv2(b, a % b, y, x)
        println("$d $x2 $y2 ${a / b}")
        return Triple(d, x2, y2 - a / b * x2)
    }

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
    class UnionFindTree(val size: Int) {
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
}