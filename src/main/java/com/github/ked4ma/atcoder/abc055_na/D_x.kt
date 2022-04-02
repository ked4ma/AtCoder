package com.github.ked4ma.atcoder.abc055_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val n = nextInt()
    val s = next()
    for (start in arrayOf("SS", "SW", "WS", "WW")) {
        val line = start.toCharArray().toMutableList()
        (1..n).forEach { index ->
            val prev = line[index - 1]
            val curr = line[index % n]
            val si = s[index % n]
            when {
                curr == 'S' && prev == 'S' -> line.add(if (si == 'o') 'S' else 'W')
                curr == 'S' && prev == 'W' -> line.add(if (si == 'o') 'W' else 'S')
                curr == 'W' && prev == 'S' -> line.add(if (si == 'o') 'W' else 'S')
                curr == 'W' && prev == 'W' -> line.add(if (si == 'o') 'S' else 'W')
            }
        }
        // validate
        if (line[0] == line[n] && line[1] == line[n + 1]) {
            println(line.subList(0, n).joinToString(separator = ""))
            return
        }
    }
    println(-1)
}
