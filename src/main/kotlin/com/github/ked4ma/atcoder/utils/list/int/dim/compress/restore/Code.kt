package com.github.ked4ma.atcoder.utils.list.int.dim.compress.restore

import com.github.ked4ma.atcoder.utils.list.int.dim.compress.*
import com.github.ked4ma.atcoder.utils.repeat.*

/**
 * make compressed list and restore map
 *
 * e.g. [9,2,1000,3] -> [2,0,3,1] and {2->9,0->2,3->1000,1->3}
 */
fun List<Int>.compressAndRestore(): Pair<List<Int>, Map<Int, Int>> {
    val comp = this.compress()
    val rest = buildMap {
        for (i in range(this@compressAndRestore.size)) {
            put(comp[i], this@compressAndRestore[i])
        }
    }
    return comp to rest
}
