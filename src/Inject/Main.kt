package Inject

/**
 * Created by yangzhiwen on 17/7/21.
 */


inline fun <reified V> Activity.inject(key: String): Lazy<V?> = lazy { ModuleManager.getProperty<V>(key) }

inline fun <reified V> Activity.inject(): Lazy<Any?> = lazy { ModuleManager.getProperty<V>() }

data class Person(var name: String, var age: Int)

class Activity {
    val tag by inject<String>("tag")
    val count by inject<Int>("count")
    val tagChar by inject<Char>("tag")
    val person by inject<Person>()
}

class MyModule : Module() {
    override fun onCreate() =
            provide {
                //...
                //...
                addProperty(Person("dazz", 100))
                addProperty("tag", "this is tag")
                addProperty("count", 12)
            }
}

fun main(args: Array<String>) {
    val myModule = MyModule()
    myModule.onCreate()

    var activity = Activity()
    println(activity.tag)
    println(activity.count)
    println(activity.tagChar)
    println(activity.person)
}