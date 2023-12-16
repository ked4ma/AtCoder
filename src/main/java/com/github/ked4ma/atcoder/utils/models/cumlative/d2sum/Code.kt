package com.github.ked4ma.atcoder.utils.models.cumlative.d2sum

class CumulativeSum2D {
    private val h: Int
    private val w: Int
    val data: Array<LongArray>

    /**
     * NOTE: only use for one time initialization.
     * If need to recreate several time, use set and build func.
     */
    constructor(arr: Array<Array<out Number>>) {
        h = arr.size
        w = arr.first().size
        data = Array(h + 1) { LongArray(w + 1) { 0L } }
        for (i in 0 until h) {
            for (j in 0 until w) {
                data[i + 1][j + 1] = data[i][j + 1] + data[i + 1][j] - data[i][j] + arr[i][j].toLong()
            }
        }
    }

    constructor(arr: Array<LongArray>) {
        h = arr.size
        w = arr.first().size
        data = Array(h + 1) { LongArray(w + 1) { 0L } }
        for (i in 0 until h) {
            for (j in 0 until w) {
                data[i + 1][j + 1] = data[i][j + 1] + data[i + 1][j] - data[i][j] + arr[i][j]
            }
        }
    }

    constructor(h: Int, w: Int) {
        this.h = h
        this.w = w
        data = Array(h + 1) { LongArray(w + 1) { 0L } }
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

    // get sum
    // NOTE: [startX,endX], [startY,endY]
    //   sections are all inclusive
    fun getSumOf(startX: Int, startY: Int, endX: Int, endY: Int): Long =
        data[endY + 1][endX + 1] - data[endY + 1][startX] - data[startY][endX + 1] + data[startY][startX]
}
