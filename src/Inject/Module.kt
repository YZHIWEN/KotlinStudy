package Inject

/**
 * Created by yangzhiwen on 17/7/21.
 */
fun <T : Module> T.provide(init: T.() -> Unit) = run(init)

abstract class Module {
    fun <T : Any> addProperty(key: String, value: T) {
        println("add property {$key : $value}")
        ModuleManager.addProperty(key, value)
    }

    fun <T : Any> addProperty(t: T) {
        println("add property {$t}")
        ModuleManager.addProperty(t)
    }

    abstract fun onCreate()
}


