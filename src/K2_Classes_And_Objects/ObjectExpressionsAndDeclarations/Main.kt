package K2_Classes_And_Objects.ObjectExpressionsAndDeclarations

/**
 * Created by Dazz on 2017/7/18.
 */

class View {
    fun setListener(listener: Listener) {
    }

    fun setCallback(callback: Callback) {
    }
}

interface Listener {
    fun onClick()
}

open class Callback {
    open fun call() {

    }
}


open class A(x: Int) {
    public open val y: Int = x
}

interface B {
}

class C {
    companion object {
        fun create() {
        }
    }
}

fun main(args: Array<String>) {
    var view = View()
    view.setCallback(object : Callback() {
        override fun call() {

        }
    })

    view.setListener(object : Listener {
        override fun onClick() {

        }
    })

//    如果父类有构造函数，则必须传递相应的构造参数。多个父类可以用逗号隔开，跟在冒号后面：
    val ab: A = object : A(1), B {
        override val y = 15
    }

    println(ab.y)


    C.create()
}