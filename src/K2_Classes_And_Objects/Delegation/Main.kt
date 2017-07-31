package K2_Classes_And_Objects.Delegation

import kotlin.reflect.KProperty

/**
 * Created by Dazz on 2017/7/18.
 */

val lazyValue: String by lazy {
    println("lazyValue")
    "value"
}

class View {
    var visibility = 0
}

class Delegate(var pro: View) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        println("$thisRef, thank you for delegating '${property.name}' to me!")
        return pro.visibility
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
        pro.visibility = value
    }
}

fun main(args: Array<String>) {

    println(lazyValue)
    println(lazyValue)

    var obj = View()

    var vvv: Int by Delegate(obj)
    vvv = 112
    println(vvv)

    println(obj.visibility)

    obj.visibility = 1111
    println(vvv)
}