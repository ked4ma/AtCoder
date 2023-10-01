package com.github.ked4ma.atcoder.abc322

import com.github.ked4ma.atcoder.utils.array.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.loop.*

fun main() {
    val P = times(3) {
        times(4) {
            next().toCharArray().toTypedArray()
        }.toTypedArray()
    }.toTypedArray()

    fun dfs(index: Int, exist: Array<Array<Boolean>>): Boolean {
        if (index == 3) {
            return exist.all { row -> row.all { it } }
        }
        (-3 until 4).forEach { di ->
            (-3 until 4).forEach { dj ->
                val ex = exist.copy()
                if (P[index].canPut(ex, di, dj)) {
                    if (dfs(index + 1, ex)) return true
                }
            }
        }
        return false
    }

    repeat(4) {
        repeat(4) {
            if (dfs(0, sized2DArray(4, 4, false))) {
                println("Yes")
                return
            }
            P[2] = P[2].rotate()
        }
        P[1] = P[1].rotate()
    }
    println("No")
}

private fun Array<Array<Char>>.rotate(): Array<Array<Char>> {
    val res = sized2DArray(4, 4, '.')
    repeat(4) { i ->
        repeat(4) { j ->
            res[3 - j][i] = this[i][j]
        }
    }
    return res
}

private fun Array<Array<Boolean>>.copy(): Array<Array<Boolean>> {
    val res = sized2DArray(4, 4, false)
    repeat(4) { i ->
        repeat(4) { j ->
            res[i][j] = this[i][j]
        }
    }
    return res
}

private fun Array<Array<Char>>.canPut(
    exist: Array<Array<Boolean>>,
    di: Int,
    dj: Int
): Boolean {
    repeat(4) { i ->
        repeat(4) { j ->
            if (this[i][j] == '#') {
                val ni = i + di
                val nj = j + dj
                if (!(ni in (0 until 4) && nj in (0 until 4))) return false
                if (exist[ni][nj]) return false
                exist[ni][nj] = true
            }
        }
    }
    return true
}