package com.github.ked4ma.atcoder.utils2.math.combimation

import com.github.ked4ma.atcoder.utils2.debug.*

// calc nCr
// e.g. 5C2 = 5!/(3!2!) = 10
// ref: https://qiita.com/TaigaTinouchi/items/feb96ac5b6838d44d8c1
//
//  nCr    n - r + 1
// ----- = ---------
// nCr-1       r
fun combination(n: Long, r: Long): Long {
    _debug_require(n >= 0) { "n($n) must be larger than or equals to 0" }
    _debug_require(r <= n) { "r($r) must be smaller than or equals to n($n)" }
    var ans = 1L
    for (i in 1..r) {
        ans = ans * (n - i + 1) / i
    }
    return ans
}
