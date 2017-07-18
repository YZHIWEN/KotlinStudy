package K2_Classes_And_Objects.Classes.Class

//import kotlin.reflect.jvm.internal.impl.javax.inject.Inject

/**
 * Created by Dazz on 2017/7/15.
 */

class Empty

class Invoice {}

class Person constructor(name: String)
// == class Person(name: String)
//If the constructor has annotations or visibility modifiers, the constructor keyword is required, and the modifiers go before it:
class P private

//@Inject

constructor(name: String)

class Customer(name: String) {
    val key = name.toUpperCase()

    //    initializer blocks,
    init {
        println("Customer name : $name")
    }
}

// 没有主构造器
class Love {
    constructor(name: String) {
    }
}

class MyLove(name: String) {
    constructor(name: String, age: Int) : this(name) {
    }
}

fun main(args: Array<String>) {
    val m = MyLove("12",1)
}
