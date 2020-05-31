package codeforces.KotlinHeroesPractice4

/**
 * Created by ccoli on 2020/05/30.
 */

fun main() {
    val tc = readLine()!!.toInt();
    for (i in 1..tc) {
        val str = readLine()!!;
        val len = str.length;
        println(len);
        var a = str.toInt();
        for (j in len - 1 downTo 1) {
            val b = Math.pow(10.0, j.toDouble()).toInt();
            val v = a % b;
            if (v != 0) {
                print(v);
                print(" ");
                a -= v;
            }
        }
        println();
    }
}