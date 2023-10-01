package com.github.ked4ma.atcoder.abc173

import com.github.ked4ma.atcoder.utils.array.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (h, w, k) = nextIntList()
    val mat = (0 until h).map {
        next()
    }
    var res = 0
//    val rowSelection = sizedArray(h, false)
//    val columnSelection = sizedArray(w, false)

    fun calcW(index: Int, selecH: Array<Int>, selecW: List<Boolean>) {
        if (index == w) {
            // calc result
            if (selecH.filterIndexed { indx, _ -> selecW[indx] }.sum() == k) {
                res++
            }
            return
        }
        // true
        calcW(index + 1, selecH, selecW + true)
        // false
        calcW(index + 1, selecH, selecW + false)
    }

    fun calcH(index: Int, selec: Array<Int>) {
        if (index == h) {
            calcW(0, selec, listOf())
            return
        }
        // true
        val row = mat[index]
        calcH(index + 1, selec.mapIndexed { indx, i -> i + (if (row[indx] == '#') 1 else 0) }.toTypedArray())
        // false
        calcH(index + 1, selec)
    }

    calcH(0, sizedArray(w, 0))
    println(res)
}
