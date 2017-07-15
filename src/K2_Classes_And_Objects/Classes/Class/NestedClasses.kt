package K2_Classes_And_Objects.Classes.Class

/**
 * Created by Dazz on 2017/7/15.
 */

class Outer{
    private val bar = 1
    class Nested{
        fun foo() = 2
    }

    inner class Inner{
        fun foo() = bar
    }
}



fun main(args: Array<String>) {
    var res = Outer.Nested().foo()
    println(res)

    res = Outer().Inner().foo()
    println(res)
}