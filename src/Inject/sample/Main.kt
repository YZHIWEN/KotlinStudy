package Inject.sample

import Inject.library.Module
import Inject.library.ModuleManager
import Inject.library.provide

/**
 * Created by yangzhiwen on 17/7/21.
 */

// 数据
data class Person(var name: String, var age: Int)

class Service {
    fun start() {
        println("start service!!")
    }
}

// module
class MyModule : Module() {
    override fun onCreate() = provide {
        registerProperty(Person("dazz", 100))
        registerProperty("tag", "this is tag")
        registerProperty("count", 12)
        //... so on
    }
}

class ServiceModule : Module() {
    override fun onCreate() = provide {
        registerProperty(Service())
        //... so on
    }
}

// 数据使用者
class Activity {
    val tag by inject<String>("tag")
    val count by inject<Int>("count")
    val tagChar by inject<Char>("tag")
    val person by inject<Person>()
    val service by inject<Service>()
}

// 程序入口
fun main(args: Array<String>) {
    ModuleManager.registerModule(MyModule())
    ModuleManager.registerModule(ServiceModule())

    val activity = Activity()
    println(activity.tag)
    println(activity.count)
    println(activity.tagChar)
    println(activity.person)
    activity.service?.start()
}