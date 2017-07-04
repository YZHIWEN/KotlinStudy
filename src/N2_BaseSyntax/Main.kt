package N2_BaseSyntax

/**
 * Created by Dazz on 2017/7/4.
 */

fun main(args: Array<String>) {
    println(max(1, 5))

    println(getStringLength("123"))
    println(getStringLength(1))

    val x = 2;
    if (x in 1..4)
        println("x in 1..4")

    for(a in 1..5)
        print("$a")
    println()

    val array = arrayListOf<String>()
    array.add("aaa")
    array.add("bbb")
    array.add("ccc")

    if("ddd" !in array)
        println("ddd !in array")


    cases("Hello")
    cases(1)
    cases(0L)
    cases(Any())

}

/**
 * `if` is an expression, i.e. it returns a value.
 * Therefore there is no ternary operator (condition ? then : else),
 * because ordinary `if` works fine in this role.
 * See http://kotlinlang.org/docs/reference/control-flow.html#if-expression
 */
fun max(a: Int, b: Int) = if (a > b) a else b

/**
 * The `is` operator checks if an expression is an instance of a type and more.
 * If we is-checked an immutable local variable or property, there's no need
 * to cast it explicitly to the is-checked type.
 * See this pages for details:
 * http://kotlinlang.org/docs/reference/classes.html#classes-and-inheritance
 * http://kotlinlang.org/docs/reference/typecasts.html#smart-casts
 */
fun getStringLength(obj: Any): Int? {
    if (obj is String)
        return obj.length // no cast to String is needed
    return null
}


fun cases(obj: Any) {
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}