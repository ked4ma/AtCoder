package com.github.ked4ma.atcoder.utils.models.number.mod.long

import com.github.ked4ma.atcoder.utils.math.mod.*

data class ModLong(private val value: Long, private val mod: Long = MOD) : Number(), Comparable<ModLong> {
    override fun toByte(): Byte = value.toByte()
    override fun toChar(): Char = value.toInt().toChar()
    override fun toDouble(): Double = value.toDouble()
    override fun toFloat(): Float = value.toFloat()
    override fun toInt(): Int = value.toInt()
    override fun toLong(): Long = value
    override fun toShort(): Short = value.toShort()
    override fun compareTo(other: ModLong): Int = value.compareTo(other.value)

    operator fun plus(n: ModLong): ModLong = ((value + n.value) % mod).toModLong(mod)
    operator fun minus(n: ModLong): ModLong = ((value - n.value + mod) % mod).toModLong(mod)
    operator fun times(n: ModLong): ModLong = ((value * n.value) % mod).toModLong(mod)
    operator fun div(n: ModLong): ModLong = (value * modinv(n.value, mod)).toModLong(mod)

    operator fun plus(n: Long): ModLong = ((value + n) % mod).toModLong(mod)
    operator fun minus(n: Long): ModLong = ((value - n + mod) % mod).toModLong(mod)
    operator fun times(n: Long): ModLong = ((value * n) % mod).toModLong(mod)
    operator fun div(n: Long): ModLong = (value * modinv(n, mod)).toModLong(mod)

    private fun modinv(num: Long, mod: Long): Long {
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
}

fun Long.toModLong() = ModLong(this)
fun Long.toModLong(mod: Long) = ModLong(this, mod)
