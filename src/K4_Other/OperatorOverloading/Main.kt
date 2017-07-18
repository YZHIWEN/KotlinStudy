package K4_Other.OperatorOverloading

/**
 * Created by yangzhiwen on 17/7/18.
 */

class A

infix fun A.foo(x: Int) = x + 2

fun main(args: Array<String>) {
    var a = A()

    var x = a foo 2
    println(x)
}