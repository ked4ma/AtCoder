package com.github.ked4ma.atcoder.utils.number.mod.long

import com.github.ked4ma.atcoder.utils.math.*

data class ModLong(private val value: Long, private val mod: Long = MOD) : Number(), Comparable<ModLong> {
    override fun toByte(): Byte = value.toByte()
    override fun toChar(): Char = value.toInt().toChar()
    override fun toDouble(): Double = value.toDouble()
    override fun toFloat(): Float = value.toFloat()
    override fun toInt(): Int = value.toInt()
    override fun toLong(): Long = value
    override fun toShort(): Short = value.toShort()
    override fun compareTo(other: ModLong): Int = value.compareTo(other.value)
    operator fun plus(other: ModLong): ModLong = value.plusMod(other.value, mod).toModLong()
    operator fun minus(other: ModLong): ModLong = value.minusMod(other.value, mod).toModLong()
    operator fun times(other: ModLong): ModLong = value.timesMod(other.value, mod).toModLong()
    operator fun div(other: ModLong): ModLong = value.divMod(other.value, mod).toModLong()
}

fun Long.toModLong() = ModLong(this)
