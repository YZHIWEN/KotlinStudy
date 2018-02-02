package N4_DelegatedProperties

/**
 * Created by Dazz on 2017/7/5.
 */

/**
 * Properties stored in a map. This comes up a lot in applications like parsing JSON
 * or doing other "dynamic" stuff. Delegates take values from this map (by the string keys -
 * names of properties). Of course, you can have var's as well,
 * that will modify the map upon assignment (note that you'd need MutableMap instead of read-only Map).
 */
class Car(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

fun main(args: Array<String>) {
    val map = mapOf<String, Any?>(
            "name" to "JJ",
            "age" to 123
    )

    val car = Car(map)
    println("name = ${car.name}, age = ${car.age}")
}