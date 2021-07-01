package com.jackchapman.codingchallenges.hackerrank

/**
 * Problem: [Climbing the Leaderboard](https://www.hackerrank.com/challenges/climbing-the-leaderboard/)
 *
 * Given a leaderboard of scores, determine the player's rank after each new score
 * @param ranked The leaderboard scores in descending order
 * @param player The player's scores in ascending order
 * @return The player's leaderboard position after each score
 */
fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
    val distinct = ranked.distinct()
    var lastPosition = distinct.size

    return player.map { score ->
        distinct.binarySearch(0, lastPosition.coerceAtMost(distinct.size)) { score.compareTo(it) }.let {
            if (it < 0) -it else it + 1
        }.also { lastPosition = it }
    }.toTypedArray()
}