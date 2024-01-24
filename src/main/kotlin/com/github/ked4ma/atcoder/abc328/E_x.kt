package com.github.ked4ma.atcoder.abc328

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.combination.*
import com.github.ked4ma.atcoder.utils.models.unionfind.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextLongList().let { (N, M, K) ->
        Triple(N.toInt(), M.toInt(), K)
    }
    val edges = timesWithLong(M.toLong()) {
        nextLongList().let { (u, v, w) ->
            Triple(u.toInt() - 1, v.toInt() - 1, w)
        }
    }

    var ans = Long.MAX_VALUE
    edges.combinations(N - 1).forEach { edgeList ->
        var sum = 0L
        val uf = UnionFind(N)
        edgeList.forEach { (u, v, w) ->
            uf.unite(min(u, v), max(u, v))
            sum += w
        }
        if (uf.roots.toSet().size == 1) {
            ans = min(ans, sum % K)
        }
    }
    println(ans)
}