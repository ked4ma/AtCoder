package com.github.ked4ma.atcoder.abc345

import com.github.ked4ma.atcoder.utils.array.int.d2.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, H, W) = nextIntList()
    val tiles = times(N) {
        val (a, b) = nextIntList()
        a to b
    }
    val board = sized2DIntArray(H, W, 0)
    fun dfs(unused: Int = (1 shl N) - 1, curI: Int = 0, curJ: Int = 0): Boolean {
        var i = curI
        var j = curJ
        while (board[i][j] > 0) {
            j++
            if (j >= W) {
                i++
                j = 0
            }
            if (i >= H) break
        }
        if (i >= H) return true

        for (n in range(N)) {
            if (unused and (1 shl n) == 0) continue
            val (a, b) = tiles[n]
            var can = true
            for (ii in range(a)) {
                for (jj in range(b)) {
                    if (i + ii < H && j + jj < W) {
                        board[i + ii][j + jj]++
                        if (board[i + ii][j + jj] > 1) {
                            can = false
                        }
                    } else {
                        can = false
                    }
                }
            }
            if (can) {
                if (dfs(unused xor (1 shl n), i, j)) return true
            }
            for (ii in range(a)) {
                for (jj in range(b)) {
                    if (i + ii < H && j + jj < W) {
                        board[i + ii][j + jj]--
                    }
                }
            }
            if (a != b) {
                can = true
                for (ii in range(b)) {
                    for (jj in range(a)) {
                        if (i + ii < H && j + jj < W) {
                            board[i + ii][j + jj]++
                            if (board[i + ii][j + jj] > 1) {
                                can = false
                            }
                        } else {
                            can = false
                        }
                    }
                }
                if (can) {
                    if (dfs(unused xor (1 shl n), i, j)) return true
                }
                for (ii in range(b)) {
                    for (jj in range(a)) {
                        if (i + ii < H && j + jj < W) {
                            board[i + ii][j + jj]--
                        }
                    }
                }
            }
        }
        return false
    }

    println(if (dfs()) "Yes" else "No")
}