package com.github.khronos227.atcoder.template.simple

fun main() {
    println("This is template.")
    println("1: Implement solution")
    println("2: ./gradlew run")
    println("     or")
    println("   ./gradlew run < [path/to/input.txt]")
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

class UnionFindTree(val size: Int) {
    private val r = com.github.khronos227.atcoder.abc177_na.sizedArray(size, -1)
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