package Inject


/**
 * Created by yangzhiwen on 17/7/21.
 */

object ModuleManager {

    var map = mutableMapOf<String, Any>()
    var set = mutableSetOf<Any>()

    inline fun <reified T> getProperty(): Any? {
        return set.filter { it.javaClass.toString() == T::class.toString() }.firstOrNull()
    }

    inline fun <reified T> getProperty(key: String): T? {
        val res = map[key]
        if (res != null && res is T) return res
        else return null
    }

    fun <T : Any> addProperty(key: String, value: T) {
        map[key] = value
    }

    fun <T : Any> addProperty(property: T) {
        set.add(property)
    }
}