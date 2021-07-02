package com.jackchapman.codingchallenges.hackerrank

import kotlin.math.abs

/**
 * Problem: [Queen's Attack II](https://www.hackerrank.com/challenges/queens-attack-2/)
 *
 * Given a chess board and a list of obstacles, find the number of valid moves a queen can make
 * @param size The size of the chess board
 * @param k The number of obstacles on the board
 * @param obstacles An array of obstacles represented as an array of two integers (it's y and x coordinate)
 * @return The number of valid moves a queen could make
 */
fun queensAttack(size: Int, k: Int, y: Int, x: Int, obstacles: Array<IntArray>): Int {
    val closest = obstacles.asSequence()
        .filter { it[0] == y || it[1] == x || abs(it[0] - y) == abs(it[1] - x) }
        .groupBy { (if (it[0] > y) 1 else if (it[0] < y) 2 else 0) or (if (it[1] > x) 4 else if (it[1] < x) 8 else 0) }
        .mapValues { (dir, arr) ->
            when {
                dir and 1 != 0 -> arr.minByOrNull { it[0] }!!
                dir and 2 != 0 -> arr.maxByOrNull { it[0] }!!
                dir and 4 != 0 -> arr.minByOrNull { it[1] }!!
                dir and 8 != 0 -> arr.maxByOrNull { it[1] }!!
                else -> throw IllegalStateException()
            }
        }

    return arrayOf(1, 2, 4, 5, 6, 8, 9, 10).sumOf {
        val obstacle = closest[it] ?: return@sumOf minOf(
            if (it and 1 != 0) size - y else Int.MAX_VALUE,
            if (it and 2 != 0) y - 1 else Int.MAX_VALUE,
            if (it and 4 != 0) size - x else Int.MAX_VALUE,
            if (it and 8 != 0) x - 1 else Int.MAX_VALUE,
        )
        maxOf(abs(obstacle[0] - y), abs(obstacle[1] - x)) - 1
    }
}