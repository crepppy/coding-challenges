package com.jackchapman.codingchallenges.hackerrank

typealias Plus = List<Pair<Int, Int>>

/**
 * Problem: [Ema's Supercomputer](https://www.hackerrank.com/challenges/two-pluses/)
 *
 * Given a matrix of good (`G`) cells and bad (`B`) cells, find 2 pluses made of
 * good cells whose area has the greatest product
 * @param grid A 2D character matrix made of good and bad cells
 * @return The product of the 2 largest pluses
 */
fun twoPluses(grid: Array<String>): Int {
    val m = grid.map { it.toCharArray() }
    return m.maxOf { i, j ->
        var firstRadius = 0
        var curMax = 0
        var firstPlus = cross(i, j, firstRadius)
        while (firstPlus.isValid(m)) {
            curMax = maxOf(curMax, firstPlus.size * m.maxOf(i, j) { y, x ->
                var secondRadius = 0
                var secondPlus: Plus
                do secondPlus = cross(y, x, secondRadius++)
                while (secondPlus.isValid(m) && secondPlus.none { it in firstPlus })
                secondPlus.size - 4
            })
            firstPlus = cross(i, j, ++firstRadius)
        } 
        curMax
    }
}

/**
 * Returns the largest value among all values produced by selector function applied to each element in the matrix
 * @see Iterable.maxOf
 */
private inline fun List<CharArray>.maxOf(startY: Int = 0, startX: Int = 0, receiver: (Int, Int) -> Int) =
    (startY until size).maxOf { i -> (startX until first().size).maxOf { j -> receiver(i, j) } }

/**
 * Ensures that each index in a list of indices is inside a given matrix and is a 'good' cell
 */
private fun Plus.isValid(matrix: List<CharArray>): Boolean =
    none { (y, x) -> y !in matrix.indices || x !in matrix[0].indices } && map { (y, x) -> matrix[y][x] }.none { it != 'G' }

/**
 * Given an index of the centre of a plus, determine all the indices of each of the cells in the plus 
 */
private fun cross(row: Int, col: Int, n: Int): Plus =
    ((col - n until col) + (col + 1..col + n)).map { row to it } + (row - n..row + n).map { it to col }