package K1_Basics.Control_Flow

/**
 * Created by Dazz on 2017/7/15.
 */

var a = 1
var b = 0
var max = if (true) a else b
val max2 = if (a > b) {
    println("Choose a")
    a
} else {
    println("Choose b")
    b
}

fun max(a: Int, b: Int) = if (a > b) a else b

fun switch(a:Int) = when(a){
    in 1..10 -> "a in 1..10"
    in 11..20 -> 12
    else -> println("else")
}

fun main(args: Array<String>) {
    println(max)
    println(max2)


    println(switch(1))
    println(switch(11))
    println(switch(1000))
}