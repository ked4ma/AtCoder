package com.github.ked4ma.atcoder.utils.array.wrap

class WrappedArray<T>(private val arrayAccessor: ArrayAccessor<T>) : ArrayAccessor<T> by arrayAccessor {

    companion object {
        inline fun <reified T> of(size: Int, noinline init: (Int) -> T): WrappedArray<T> {
            val arr = when (T::class) {
                Int::class -> IntArrayAccessor.of(IntArray(size, init as (Int) -> Int))
                Long::class -> LongArrayAccessor.of(LongArray(size, init as (Int) -> Long))
                Boolean::class -> BooleanArrayAccessor.of(BooleanArray(size, init as (Int) -> Boolean))
                else -> DefaultArrayAccessor(Array(size, init))
            } as ArrayAccessor<T>
            return WrappedArray(arr)
        }
    }
}

sealed interface ArrayAccessor<T> {
    operator fun get(index: Int): T
    operator fun set(index: Int, value: T): Unit
    val size: Int
    operator fun iterator(): Iterator<T>
}

class IntArrayAccessor private constructor(private val arr: IntArray) : ArrayAccessor<Int> {
    override operator fun get(index: Int) = arr[index]
    override fun set(index: Int, value: Int) {
        arr[index] = value
    }

    override val size: Int
        get() = arr.size

    override fun iterator(): Iterator<Int> = arr.iterator()

    companion object {
        fun of(arr: IntArray) = IntArrayAccessor(arr)
    }
}

class LongArrayAccessor private constructor(private val arr: LongArray) : ArrayAccessor<Long> {
    override operator fun get(index: Int) = arr[index]
    override fun set(index: Int, value: Long) {
        arr[index] = value
    }

    override val size: Int
        get() = arr.size

    override fun iterator(): Iterator<Long> = arr.iterator()

    companion object {
        fun of(arr: LongArray) = LongArrayAccessor(arr)
    }
}

class BooleanArrayAccessor private constructor(private val arr: BooleanArray) : ArrayAccessor<Boolean> {
    override operator fun get(index: Int) = arr[index]
    override fun set(index: Int, value: Boolean) {
        arr[index] = value
    }

    override val size: Int
        get() = arr.size

    override fun iterator(): Iterator<Boolean> = arr.iterator()

    companion object {
        fun of(arr: BooleanArray) = BooleanArrayAccessor(arr)
    }
}

class DefaultArrayAccessor<T>(private val arr: Array<T>) : ArrayAccessor<T> {
    override operator fun get(index: Int) = arr[index]
    override fun set(index: Int, value: T) {
        arr[index] = value
    }

    override val size: Int
        get() = arr.size

    override fun iterator(): Iterator<T> = arr.iterator()

    companion object {
        fun <T> of(arr: Array<T>) = DefaultArrayAccessor(arr)
    }
}
