package Inject.library

/**
 * Created by yangzhiwen on 17/7/21.
 */
fun <T : Inject.library.Module> T.provide(init: T.() -> Unit) = run(init)

abstract class Module {
    fun <T : Any> registerProperty(key: String, value: T) {
        println("add property {$key : $value}")
        Inject.ModuleManager.addProperty(key, value)
    }

    fun <T : Any> registerProperty(t: T) {
        println("add property {$t}")
        Inject.ModuleManager.addProperty(t)
    }

    abstract fun onCreate()
}


