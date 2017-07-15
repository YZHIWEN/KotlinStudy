package K1_Basics.Control_Flow

/**
 * Created by Dazz on 2017/7/15.
 */

var a = 1
var b = 0
var max = if(true) a else b
val max2 = if (a > b) {
    println("Choose a")
    a
} else {
    println("Choose b")
    b
}

fun main(args: Array<String>) {
    println(max)
    println(max2)
}