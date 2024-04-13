package com.github.ked4ma.atcoder.abc349

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next().uppercase().toCharArray()
    val T = next().toCharArray()
    fun check(t: CharArray): Boolean {
        _debug_println(t.joinToString(""))
        var i = 0
        for (c in t) {
            while (i < S.size && S[i] != c) {
                i++
            }
            if (i == S.size) return false
            i += 1
        }
        return true
    }
    println(
        if (check(if (T.last() == 'X') T.slice(0 until T.lastIndex).toCharArray() else T)) {
            "Yes"
        } else {
            "No"
        }
    )
}
// fun main() {
//     val S = (next()+"x").uppercase().toCharArray() // longer
//     val T = next().toCharArray()
//     var cnt = 0
//     var l = 0
//     for (t in 0 until T.size) {
//         if (cnt < t) break
//         for (s in l until S.size) {
//             if (T[t] == S[s]) {
//                 l = s + 1
//                 cnt++
//                 break
//             }
//         }
//     }
//     println(if (cnt == 3) "Yes" else "No")
// }
//