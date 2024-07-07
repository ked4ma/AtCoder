package com.github.ked4ma.atcoder.abc361

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next()
    val T = next()

    if (S == T) {
        println(0)
        return
    }
    if (S.toList().sorted() != T.toList().sorted()) {
        println(-1)
        return
    }


    val queue = ArrayDeque<Pair<String, Int>>()
    queue.addLast("$S.." to N)

    val T2 = "$T.."
    var ans = 0
    val visit = mutableSetOf<String>()
    while (queue.isNotEmpty()) {
        val l = queue.size
        repeat(l) {
            val (cur, k) = queue.removeFirst()
            if (cur == T2) {
                println(ans)
                return
            }
            if (cur in visit) return@repeat
            visit.add(cur)

            val arr = cur.toCharArray()
            for (i in range(N + 1)) {
                if (i != k && i != k + 1 && i + 1 != k) {
                    arr[k] = arr[i]
                    arr[k + 1] = arr[i + 1]
                    arr[i] = '.'
                    arr[i + 1] = '.'
                    queue.addLast(arr.joinToString("") to i)
                    arr[i] = arr[k]
                    arr[i + 1] = arr[k + 1]
                    arr[k] = '.'
                    arr[k + 1] = '.'
                }
            }
        }
        ans++
    }
    println(-1)
}
