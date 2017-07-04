package N3_DataClasses

/**
 * Created by Dazz on 2017/7/4.
 */

fun main(args: Array<String>) {

    val pair = Pair(1, "Dazz")
    val (num, name) = pair
    println("num = $num, name = $name")

    val user = User("Dazz", 3)
    println("name = ${user.name}, id = ${user.id}")
    println("name = ${user.component1()}, id = ${user.component2()}")

    val sUser = User("Dazz", 3)
    val tUser = User("Max", 2)
    println("user == sUser : ${user == sUser}")
    println("user == tUser : ${user == tUser}")

    println(user.copy())
    println(user.copy("Yes"))
    println(user.copy("OK", 11))
    println(user.copy(id = 123))
}

/**
 * This example introduces a concept that we call destructuring declarations.
 * It creates multiple variable at once. Anything can be on the right-hand
 * side of a destructuring declaration, as long as the required number of component
 * functions can be called on it.
 * See http://kotlinlang.org/docs/reference/multi-declarations.html#multi-declarations
 */
class Pair<K, V>(val first: K, val second: V) {
    operator fun component1(): K {
        return first
    }

    operator fun component2(): V {
        return second
    }
}

/**
 *  Data class gets component functions, one for each property declared
 *  in the primary constructor, generated automatically, same for all the
 *  other goodies common for data: toString(), equals(), hashCode() and copy().
 *  See http://kotlinlang.org/docs/reference/data-classes.html#data-classes
 */
data class User(val name: String, val id: Int)