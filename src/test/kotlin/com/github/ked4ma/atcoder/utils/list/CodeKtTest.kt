package com.github.ked4ma.atcoder.utils.list

import com.github.ked4ma.atcoder.utils.list.combination.*
import com.github.ked4ma.atcoder.utils.list.permutation.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CodeKtTest {

    @Nested
    inner class CombinationsTest {
        @Test
        fun test_combinations_without_repetition() {
            val input = listOf(0, 1, 2, 3)
            val expected = listOf(
                listOf(0, 1, 2),
                listOf(0, 1, 3),
                listOf(0, 2, 3),
                listOf(1, 2, 3),
            )
            assertEquals(expected, input.combinations(3).toList())
        }

        @Test
        fun test_combinations_with_repetition() {
            val input = listOf(0, 1, 2)
            val expected = listOf(
                listOf(0, 0),
                listOf(0, 1),
                listOf(0, 2),
                listOf(1, 1),
                listOf(1, 2),
                listOf(2, 2),
            )
            assertEquals(expected, input.combinations(2, true).toList())
        }
    }

    @Nested
    inner class PermutationsTest {
        @Test
        fun test_permutations_without_repetition() {
            val input = listOf(0, 1, 2, 3)
            val expected = listOf(
                listOf(0, 1),
                listOf(0, 2),
                listOf(0, 3),
                listOf(1, 0),
                listOf(1, 2),
                listOf(1, 3),
                listOf(2, 0),
                listOf(2, 1),
                listOf(2, 3),
                listOf(3, 0),
                listOf(3, 1),
                listOf(3, 2),
            )
            assertEquals(expected, input.permutations(2).toList())
        }

        @Test
        fun test_permutations_with_repetition() {
            val input = listOf(0, 1, 2, 3)
            val expected = listOf(
                listOf(0, 0),
                listOf(0, 1),
                listOf(0, 2),
                listOf(0, 3),
                listOf(1, 0),
                listOf(1, 1),
                listOf(1, 2),
                listOf(1, 3),
                listOf(2, 0),
                listOf(2, 1),
                listOf(2, 2),
                listOf(2, 3),
                listOf(3, 0),
                listOf(3, 1),
                listOf(3, 2),
                listOf(3, 3),
            )
            assertEquals(expected, input.permutations(2, true).toList())
        }
    }
}
