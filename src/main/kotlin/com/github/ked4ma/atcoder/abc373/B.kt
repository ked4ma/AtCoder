package com.github.ked4ma.atcoder.abc373

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val keyboard = sizedIntArray(26, 0)
    for (i in range(26)) {
        keyboard[S[i] - 'A'] = i
    }
    var cur = keyboard[0]
    var ans = 0
    for (i in range(26)) {
        ans += abs(keyboard[i] - cur)
        cur = keyboard[i]
    }
    println(ans)
}
