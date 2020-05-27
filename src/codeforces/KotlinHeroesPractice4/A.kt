package codeforces.KotlinHeroesPractice4

/**
 * Created by ccoli on 2020/05/25.
 */

fun main(){
    val tc = readLine()!!.toInt();
    for (i in 1.. tc) {
        val (a, b) = readLine()!!.split(' ')
        println(a.toInt() + b.toInt())
    }
}

fun main2() {
    var t:Int= readLine()!!.toInt()
    for (i in 1..t){
        var line = readLine()!!.split(" ")
        println(line[0].toInt()+line[1].toInt())
    }
}

fun main3() {
    val t = readLine()!!.toInt()
    val list = mutableListOf<Int>()
    for (i in 1..t) {
        val (a, b) = readLine()!!.split(" ")
        list.add(a.toInt() + b.toInt())
    }
    list.forEach { println(it) }
}

fun main4() {
    val cases = readLine()!!.toInt()
    for (x in 0 until cases) {
        val (a, b) = readLine()!!.split(' ')
        println(a.toInt() + b.toInt())
    }
}

/*
4
1 5
314 15
-99 99
123 987
 */