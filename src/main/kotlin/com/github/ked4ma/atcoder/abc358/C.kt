package com.github.ked4ma.atcoder.abc358

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.number.int.bit.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val S = times(N) {
        var i = 0
        next().forEach {
            i = i shl 1
            if (it == 'o') i++
        }
        i
    }
    _debug_println(S.joinToString(","))
    val visits = sizedIntArray(1 shl N, 0)
    for (i in range(1 shl N)) {
        var n = 0
        for (j in range(N)) {
            if (i.bit(j)) {
                n = n or S[j]
            }
        }
        visits[i] = n
    }
    _debug_println("===")
    _debug_println(visits.joinToString(","))
    var ans = Int.MAX_VALUE
    val req = (1 shl M) - 1
    _debug_println(req)
    for (i in range(1 shl N)) {
        if (visits[i] == req) {
            ans = min(ans, i.countOneBits())
        }
    }
    println(ans)
}
