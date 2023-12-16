package com.github.ked4ma.atcoder.abc203_na

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val (n, k) = nextIntList()
    val friendMap = mutableMapOf<Long, Long>()
    repeat(n) {
        val (a, b) = nextLongList()
        friendMap[a] = friendMap.getOrDefault(a, 0) + b
    }
    val sortedFriendIndex = friendMap.keys.sorted()
    _debug_println(friendMap)
    _debug_println(sortedFriendIndex)

    var i = 0L
    var j = 0
    var m = k.toLong()
    while (j <= sortedFriendIndex.lastIndex && sortedFriendIndex[j] <= i + m) {
        m += friendMap.getValue(sortedFriendIndex[j]) - (sortedFriendIndex[j] - i)
        i = sortedFriendIndex[j]
        j++
        _debug_println("$i $m $j")
    }
    println(i + m)
}
