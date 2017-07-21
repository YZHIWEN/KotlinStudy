package Inject

/**
 * Created by yangzhiwen on 17/7/21.
 */
//fun <T> T.provide(init: T.() -> Unit) = apply(init)

class A

abstract class Module {

    fun addProperty(key: String, value: String) {
        println("add property {$key : $value}")
    }

    fun <T> addProperty(t: T) {
        println("add property {$t}")
    }

    abstract fun onCreate()
}

fun Module.provide(init: Module.() -> Unit) = run(init)

//fun <T> T.inject(key: String): T {
//
//}

class MyModule : Module() {
    override fun onCreate() =
            provide {
                //...
                //...
                addProperty(A())
            }
}

class Activity {
//    val tag by inject()
}


fun main(args: Array<String>) {
    val myModule = MyModule()
    myModule.onCreate()
}