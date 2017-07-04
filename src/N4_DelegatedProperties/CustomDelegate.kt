package N4_DelegatedProperties

import kotlin.reflect.KProperty

/**
 * Created by Dazz on 2017/7/5.
 */

fun main(args: Array<String>) {

    val e = Example()
    println(e.p)
    e.p = "New"
}

class Example {
    var p: String by Delegate()

    override fun toString() = "Example Class"
}

/**
 * There's some new syntax: you can say `val 'property name': 'Type' by 'expression'`.
 * The expression after by is the delegate, because get() and set() methods
 * corresponding to the property will be delegated to it.
 * Property delegates don't have to implement any interface, but they have
 * to provide methods named getValue() and setValue() to be called.</p>
 */
class Delegate() {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to ${property.name} in $thisRef")
    }
}