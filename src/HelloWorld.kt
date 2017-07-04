/**
 * Created by Dazz on 2017/7/4.
 */

fun main(args: Array<String>) {
    println("Hello World")

    for (name in args)
        println("Hello $name")

    val language = if (args.size == 0) "EN" else args[0]
    println(when (language) {
        "EN" -> "Hello EN"
        "CN" -> "Hello CN"
        else -> "Hello ELSE"
    })

    Greeter("dazz").greet()
}

class Greeter(val name: String) {
    fun greet() {
        println("Greeter greet $name")
    }
}