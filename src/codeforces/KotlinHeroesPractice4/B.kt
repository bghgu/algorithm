package codeforces.KotlinHeroesPractice4

import kotlin.math.*

/**
 * Created by ccoli on 2020/05/28.
 */

fun main() {
    val tc = readLine()!!.toInt();
    for (i in 1..tc) {
        val (max1, min1) = readAscending();
        val (max2, min2) = readAscending();
        val result =
                if (max1 == max2 && min1 + min2 == max1) "Yes"
                else "No"
        println(result)
    }
}

fun readAscending(): Pair<Int, Int> {
    val (first, second) = readLine()!!.split(' ').map(String::toInt)
    return max(first, second) to min(first, second)
}
