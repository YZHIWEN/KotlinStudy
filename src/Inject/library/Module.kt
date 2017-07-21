package Inject.library

/**
 * Created by yangzhiwen on 17/7/21.
 */
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


