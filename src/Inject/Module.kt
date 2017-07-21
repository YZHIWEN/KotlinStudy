package Inject

/**
 * Created by yangzhiwen on 17/7/21.
 */
fun <T> T.provide(init: T.() -> Unit) = apply(init)

open class Module {

    fun addProperty(key: String, value: String) {
        println("add property {$key : $value}")
    }

}

class MyModule : Module()

fun main(args: Array<String>) {
    MyModule().provide {
        addProperty("tag", "dazz")
    }
}