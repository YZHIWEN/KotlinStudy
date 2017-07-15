package K2_Classes_And_Objects.Interfaces

/**
 * Created by Dazz on 2017/7/15.
 */

interface My{
    val prop : String

    fun foo(){
        println(prop)
    }

    val propertyWithImplementation :String
        get() = "hha"

    fun hha(){
        println(propertyWithImplementation)
    }

    fun exe()
}

class Me(override val prop: String) : My{
    override val propertyWithImplementation: String
        get() = "in Me"

    override fun exe() {
        foo()
        hha()
    }
}

fun main(args: Array<String>) {
    var me = Me("in main")
    me.exe()
}