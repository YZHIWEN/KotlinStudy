package K4_Other.Ranges

/**
 * Created by Dazz on 2017/7/16.
 */

fun main(args: Array<String>) {
    // equivalent of 1 <= i && i <= 10
    for (i in 1..10) print("$i ")

    println()
    // i in [1, 10), 10 is excluded
    for (i in 1 until 10) print("$i ")

    println()
    // prints nothing
    for (i in 10..1) print("$i ")

    println()
    for (i in 10 downTo 1) print("$i ")
}