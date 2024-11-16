package com.github.ked4ma.atcoder.abc380

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val C = sizedIntArray(N + 1, 1)
    val S = sortedSetOf(*range(N + 2).toList().toTypedArray())
    val D = range(N + 2).associateWith { it }.toMutableMap()
    _debug_println(C.joinToString(" "))
    _debug_println(S)
    _debug_println(D)

    repeat(Q) {
        val q = nextIntList()
        when (q[0]) {
            //update
            1 -> {
                val x = q[1]
                val c = q[2]
                val L = S.floor(x)!!
                val R = S.ceiling(L + 1)!!
                C[D[L]!!] -= R - L
                D[L] = c
                C[D[L]!!] += R - L
                if (D[L]!! == D[R]!!) {
                    S.remove(R)
                }
                val L2 = S.floor(L - 1)!!
                if (D[L]!! == D[L2]!!) {
                    S.remove(L)
                }
            }

            2 -> {
                println(C[q[1]])
            }
        }
    }
}

// fun main() {
//     val (N, Q) = nextIntList()
//     val uf = UnionFind(N)
//     val uf2 = UnionFind(N, false)
//     val cnt = sizedIntArray(N, 1)
//
//     repeat(Q) {
//         val q = nextIntList().map { it - 1 }
//         when (q[0]) {
//             // update
//             0 -> {
//                 val x = q[1]
//                 val c = q[2]
//                 val l = uf.find(x)
//                 val r = uf2.find(x)
//                 val bc = uf.getColor(x)
//                 if (l > 0 && uf.getColor(l - 1) == c) {
//                     uf.unite(l - 1, x)
//                     uf2.unite(l - 1, x)
//                 }
//                 if (r + 1 < N && uf2.getColor(r + 1) == c) {
//                     uf.unite(x, r + 1)
//                     uf2.unite(x, r + 1)
//                 }
//                 uf.setColor(x, c)
//                 uf2.setColor(x, c)
//                 cnt[bc] -= r - l + 1
//                 cnt[c] += r - l + 1
//             }
//             // output
//             1 -> {
//                 println(cnt[q[1]])
//             }
//         }
//     }
// }
//
// /**
//  * UnionFind
//  * @param size num of elements
//  * @param unionBySize enable "union-by-size" (default: true)
//  */
// class UnionFind(val size: Int, val unionBySize: Boolean = true) {
//     private val r = sizedIntArray(size) { -1 }
//     private val c = sizedIntArray(size) { it }
//
//     // find root
//     fun find(x: Int): Int {
//         if (r[x] < 0) return x
//         // route compression
//         val comp = mutableListOf<Int>()
//         var i = x
//         while (r[i] >= 0) {
//             comp.add(i)
//             i = r[i]
//         }
//         for (j in comp) {
//             r[j] = i
//         }
//         return i
//     }
//
//     val roots: List<Int>
//         get() = (r.indices).map { find(it) }
//
//     fun unite(x: Int, y: Int) {
//         var rx = find(x)
//         var ry = find(y)
//         if (rx == ry) return
//         if (unionBySize) {
//             if (rx > ry) {
//                 rx = ry.also { ry = rx }
//             }
//         } else {
//             if (rx < ry) {
//                 rx = ry.also { ry = rx }
//             }
//         }
//         r[rx] += r[ry]
//         r[ry] = rx
//     }
//
//     fun size(x: Int) = -r[find(x)]
//     val categories: List<Int>
//         get() = r.indices.map { find(it) }
//
//     fun same(x: Int, y: Int) = find(x) == find(y)
//
//     override fun toString(): String {
//         return r.joinToString(separator = ", ")
//     }
//
//     fun setColor(x: Int, color: Int) {
//         c[find(x)] = color
//     }
//
//     fun getColor(x: Int) = c[find(x)]
// }
