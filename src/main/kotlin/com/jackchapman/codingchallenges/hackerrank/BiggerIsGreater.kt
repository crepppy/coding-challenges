package com.jackchapman.codingchallenges.hackerrank

/**
 * Problem: [Bigger Is Greater](https://www.hackerrank.com/challenges/bigger-is-greater/)
 *
 * By swapping some or all of the characters in a word, create a new word that must be next lexicographically greatest 
 * @param word The word 
 * @return The next greatest permutation of the word
 */
fun biggerIsGreater(word: String): String {
    val bank = mutableListOf(word.last())
    word.reversed().drop(1).forEach { 
        bank += it
        if(bank[bank.size - 2] > it) {
            val rep = bank.minWithOrNull { a, b ->
                if (a > it) if (a < b) -1 else 0 else 1
            }!!
            if(rep > it) {
                bank.remove(rep)
                return word.substring(0, word.length - bank.size - 1) + rep + bank.sorted().joinToString("")
            }
        }
    }
    return "no answer"
}