package com.github.khronos227.atcoder.abc186

import com.github.khronos227.atcoder.utils.*

// https://www.youtube.com/watch?v=hY2FicqnAcc
fun main() {
    repeat(nextInt()) {
        var (n, s, k) = nextLongList()
        gcd(gcd(n, s), k).apply {
            n /= this
            s /= this
            k /= this
        }
        if (gcd(k + n, n) == 1L) {
            val v = (modinv(k, n) * (n - s)) % n
            println(v)
        } else {
            println(-1)
        }
    }
}
