package com.github.ked4ma.atcoder.utils.loop

// repeat
inline fun <T> times(num: Long, block: (Long) -> T) = (0 until num).map {
    block.invoke(it)
}

// copy of kotlin and pass Long type for parameter
//@OptIn(ExperimentalContracts::class)
inline fun repeat(times: Long, action: (Long) -> Unit) {
//    contract { callsInPlace(action) }
    for (index in 0 until times) {
        action(index)
    }
}
