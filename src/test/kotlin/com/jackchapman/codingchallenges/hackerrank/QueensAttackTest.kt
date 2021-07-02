package com.jackchapman.codingchallenges.hackerrank

import kotlin.test.Test
import kotlin.test.assertEquals

internal class QueensAttackTest {
    @Test
    fun testQueensAttack() {
        assertEquals(10, queensAttack(
            5, 3, 4, 3, arrayOf(
                intArrayOf(5, 5),
                intArrayOf(4, 2),
                intArrayOf(2, 3),
            )
        ))

        assertEquals(9, queensAttack(
            4, 0, 4, 4, arrayOf()
        ))
    }
}