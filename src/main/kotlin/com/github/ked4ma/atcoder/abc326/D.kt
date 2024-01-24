package com.github.ked4ma.atcoder.abc326

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val strR = next()
    val strC = next()
    val R = strR.toCharArray()
    val C = strC.toCharArray()

    if (R.distinct().size != 3 || C.distinct().size != 3) {
        println("No")
        return
    }

    val set = mutableMapOf(
        'A' to setOf(
            listOf('A', 'B', 'C'),
            listOf('A', 'C', 'B'),
        ),
        'B' to setOf(
            listOf('B', 'A', 'C'),
            listOf('B', 'C', 'A'),
        ),
        'C' to setOf(
            listOf('C', 'A', 'B'),
            listOf('C', 'B', 'A'),
        ),
    )
    (4..N).forEach { size ->
        set.forEach { key, s ->
            val tmp = mutableSetOf<List<Char>>()
            s.forEach {
                for (i in 0 until size) {
                    ArrayList(it).let {
                        it.add(i, '.')
                        tmp.add(it)
                    }
                }
            }
            set[key] = tmp
        }
    }
    _debug_println(set)

    val ans = mutableListOf<List<Char>>()
    val colsCount = sizedArray(N) { mutableListOf<Char>() }
    fun dfs(r: Int): Boolean {
        if (r == N) {
            val cols = sizedArray(N, '.')
            for (i in 0 until N) {
                for (j in 0 until N) {
                    if (cols[j] == '.' && ans[i][j] != '.') {
                        cols[j] = ans[i][j]
                    }
                }
            }

            if (colsCount.all { it.size == 3 && it.distinct().size == 3 } && cols.joinToString(separator = "") == strC) {
                println("Yes")
                ans.forEach { row ->
                    println(row.joinToString(separator = ""))
                }
                return true
            }
            return false
        }
        set.getValue(R[r]).forEach { row ->
            ans.add(row)
            row.forEachIndexed { index, c ->
                if (c != '.') {
                    colsCount[index].add(c)
                }
            }
            if (dfs(r + 1)) {
                return true
            }
            ans.removeLast()
            row.forEachIndexed { index, c ->
                if (c != '.') {
                    colsCount[index].removeLast()
                }
            }
        }
        return false
    }
    if (dfs(0)) {
        return
    }
    println("No")
}