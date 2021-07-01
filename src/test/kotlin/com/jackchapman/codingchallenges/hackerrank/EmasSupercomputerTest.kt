package com.jackchapman.codingchallenges.hackerrank

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

internal class EmasSupercomputerTest {
    @Test
    fun testEmasSupercomputer() {
        assertEquals(5, twoPluses(
            arrayOf(
                "GGGGGG",
                "GBBBGB",
                "GGGGGG",
                "GGBBGB",
                "GGGGGG",
            )
        ))
        
        assertEquals(25, twoPluses(
            arrayOf(
                "BGBBGB",
                "GGGGGG",
                "BGBBGB",
                "GGGGGG",
                "BGBBGB",
                "BGBBGB",
            )
        ))
        
        assertEquals(85, twoPluses(
            arrayOf(
                "BBBBBGGBGG",
                "GGGGGGGGGG",
                "GGGGGGGGGG",
                "BBBBBGGBGG",
                "BBBBBGGBGG",
                "GGGGGGGGGG",
                "BBBBBGGBGG",
                "GGGGGGGGGG",
                "BBBBBGGBGG",
                "GGGGGGGGGG",
            )
        ))
    }
}