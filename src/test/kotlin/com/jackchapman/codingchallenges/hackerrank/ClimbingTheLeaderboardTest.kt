package com.jackchapman.codingchallenges.hackerrank

import kotlin.test.Test
import kotlin.test.assertContentEquals

internal class ClimbingTheLeaderboardTest {
    @Test
    fun testClimbingLeaderboard() {
        assertContentEquals(
            arrayOf(6, 4, 2, 1),
            climbingLeaderboard(
                arrayOf(100, 100, 50, 40, 40, 20, 10),
                arrayOf(5, 25, 50, 120)
            )
        )

        assertContentEquals(
            arrayOf(6, 5, 4, 2, 1),
            climbingLeaderboard(
                arrayOf(100, 90, 90, 80, 75, 60),
                arrayOf(50, 65, 77, 90, 102)
            )
        )
    }
}