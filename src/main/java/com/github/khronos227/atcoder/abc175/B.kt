package com.github.khronos227.atcoder.abc175

fun main() {
    val n = nextInt()
    val l = nextIntList()
    var count = 0
    (0 until l.size - 2).forEach { i ->
        val I = l[i]
        (i + 1 until l.size - 1).forEach j@{ j ->
            val J = l[j]
            if (I == J) return@j
            (j + 1 until l.size).forEach k@{ k ->
                val K = l[k]
                if (I == K || J == K) return@k
                // println("${i + 1}, ${j + 1}, ${k + 1} = $I $J $K (${I + J > K && J + K > I && K + I > J})")
                if (I + J > K && J + K > I && K + I > J) {
                    count++
                }
            }
        }
    }
    println(count)
}
