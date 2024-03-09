package com.github.ked4ma.atcoder.abc344

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
private data class Node(val n: Int) {
    var root: Node? = null
    var next: Node? = null
}

fun main() {
    val N = nextInt()
    val A = nextIntList()
    val Q = nextInt()

    val map = mutableMapOf<Int, Node>()
    A.forEachIndexed { i, a ->
        val n = Node(a)
        map[a] = n
        if (i > 0) {
            val root = map.getValue(A[i - 1])
            n.root = root
            root.next = n
        }
    }

    repeat(Q) {
        val q = nextIntList()
        if (q.first() == 1) {
            val p = map.getValue(q[1])
            val n = Node(q[2])
            map[q[2]] = n
            p.next?.root = n
            n.next = p.next
            n.root = p
            p.next = n
        } else {
            val n = map.getValue(q[1])
            n.root?.next = n.next
            n.next?.root = n.root
            map.remove(q[1])
        }
    }

    val ans = buildList {
        var n: Node? = map.values.first { it.root == null }
        while (n != null) {
            add(n.n)
            n = n.next
        }
    }
    println(ans.joinToString(" "))
}