package Inject.sample

import Inject.library.Module
import Inject.library.ModuleManager
import Inject.library.provide

/**
 * Created by yangzhiwen on 17/7/21.
 */

inline fun <reified V> Activity.inject(key: String): Lazy<V?> = lazy { ModuleManager.getProperty<V>(key) }

inline fun <reified V> Activity.inject(): Lazy<V?> = lazy { ModuleManager.getProperty<V>() }

data class Person(var name: String, var age: Int)
class Service {
    fun start() {
        println("start service!!")
    }
}

class Activity {
    val tag by inject<String>("tag")
    val count by inject<Int>("count")
    val tagChar by inject<Char>("tag")
    val person by inject<Person>()
    val service by inject<Service>()
}

class MyModule : Module() {
    override fun onCreate() =
            provide {
                registerProperty(Person("dazz", 100))
                registerProperty("tag", "this is tag")
                registerProperty("count", 12)
                registerProperty(Service())
                //...
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
    activity.service?.start()
}