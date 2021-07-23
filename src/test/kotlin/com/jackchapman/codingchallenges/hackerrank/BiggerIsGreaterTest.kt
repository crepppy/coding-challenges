package com.jackchapman.codingchallenges.hackerrank

import kotlin.test.Test
import kotlin.test.assertEquals

internal class BiggerIsGreaterTest {
    @Test
    fun testBiggerIsGreater() {
        assertEquals("hcdk", biggerIsGreater("dkhc"))
        assertEquals("fedcbabdc", biggerIsGreater("fedcbabcd"))
        assertEquals("no answer", biggerIsGreater("mlji"))
    }
}