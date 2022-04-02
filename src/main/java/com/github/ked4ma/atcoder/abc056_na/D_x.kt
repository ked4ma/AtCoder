package com.github.ked4ma.atcoder.abc056_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (_, k) = nextIntList()

//    val arr = nextIntList().sortedDescending()
//    var ans = 0
//    var s = 0
//    for(i in 0 until n) {
//        val a = arr[i]
//        if(s + a < k) {
//            s += a
//            ans += 1
//        } else {
//            ans = 0
//        }
//    }
//    println(ans)

    val arr = mutableListOf(0, k)
    nextIntList().forEach {
        if (it < k) {
            arr.add(it)
        }
    }
    arr.sort()
    // if arr[i] is not necessary, elems that smaller than it are also not.
    // do binary search for max un-necessary value.
    val n = arr.size
    var l = 0
    var r = n
    while (l < r) {
        val mid = (l + r) / 2
        val dp = BooleanArray(k + 1)
        dp[0] = true

        for (j in arr.indices) {
            if (j == mid) continue
            for (m in k downTo arr[j]) {
                dp[m] = dp[m] or dp[m - arr[j]]
            }
        }
        var need = false
        for (m in k - arr[mid] until k) need = need or dp[m]
        if (!need) l = mid + 1 else r = mid
    }
    println(l - 1)
}
