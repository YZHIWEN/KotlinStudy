package K2_Classes_And_Objects.Classes.ClassDelegation

/**
 * Created by Dazz on 2017/7/15.
 */

//http://kotlinlang.org/docs/reference/delegation.html

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        println(x)
    }
}

// by base ： Base方法由传入的base代理实现
class Derived(base: Base) : Base by base

// 存在重写以重写的为主
class Derived2(val base: Base) : Base by base {
    override fun print() {
        println("abc")
    }
}

fun main(args: Array<String>) {
    val base = BaseImpl(12)
    val de = Derived(base)
    de.print()
    val de2 = Derived2(base)
    de2.print()
}