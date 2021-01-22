package com.github.khronos227.atcoder.abc188

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()

    class Graph(values: List<Int>) {
        val children = values.mapIndexed { index, value ->
            GraphNode(index, value)
        }

        fun bind(x: Int, y: Int) {
            children[x - 1].bind(children[y - 1])
        }

        inner class GraphNode(val index: Int, val value: Int) {
            val children = mutableListOf<GraphNode>()

            fun bind(child: GraphNode) {
                children.add(child)
            }
        }
    }

    val graph = Graph(A)
    repeat(M) {
        val (x, y) = nextIntList()
        graph.bind(x, y)
    }
    val minParentValue = sizedArray(A.size, Int.MAX_VALUE)
    for (node in graph.children) {
        for (child in node.children) {
            minParentValue[child.index] = minOf(minParentValue[child.index], minParentValue[node.index], node.value)
        }
    }
    var ans = Int.MIN_VALUE
    for (child in graph.children) {
        val v = child.value - minParentValue[child.index]
        _debug_println("${child.index} : $v")
        if (ans < v) {
            ans = v
        }
    }
    println(ans)
//    println(graph.roots.map {
//        _debug_println("root: ${it.value}")
//        graph.solve(it)
//    }.max())
}
