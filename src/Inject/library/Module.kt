package Inject.library

/**
 * Created by yangzhiwen on 17/7/21.
 */
fun <T : Module> T.provide(init: T.() -> Unit): Unit = run(init)

abstract class Module {

    init {
        onCreate()
    }

    fun <T : Any> registerProperty(key: String, value: T) {
        ModuleManager.registerProperty(key, value)
    }

    fun <T : Any> registerProperty(t: T) {
        ModuleManager.registerProperty(t)
    }

    abstract fun onCreate(): Unit
}


