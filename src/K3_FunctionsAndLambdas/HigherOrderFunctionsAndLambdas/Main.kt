package K3_FunctionsAndLambdas.HigherOrderFunctionsAndLambdas

/**
 * Created by yangzhiwen on 17/7/20.
 */

// Function Literals with Receiver
class Config {
    fun setTag(tag: String) {
        println("setTag $tag")
    }

    fun setCount(count: Int) {
        println("setCount $count")
    }

    fun setOther(other: String) {
        println("setOther $other")
    }

    fun providerFun(callback: () -> Unit) {
        callback()
    }
}

fun <T> T.build(create: T.() -> Unit): T {
    create()
    return this
}

class HTML {
    fun body() {
        println("Html body()")
    }
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}

fun main(args: Array<String>) {

    var sum = 0
    var ints = listOf(1, 2, 3, 4)
    ints.filter { it > 0 }.forEach {
        sum += it
    }
    print(sum)


    Config().build {
        setCount(111)
        setOther("build other")
        setTag("build tag")
        // ...
        providerFun {
            println("provided callback")
        }
    }

    // 这里其实就是调用html方法，传入lambda表达式，在这个lambda表达式的接受者是HTML，所以可以调用HTML的方法，这个lambda表达式在html方法中被调用也就是init方法
    html {       // lambda with receiver begins here
        body()   // calling a method on the receiver object
    }


    // Function Literals with Receiver
    val sub = fun Int.(other: Int): Int {
        println("call Int fun : " + toByte()) // 这里接受者是Int，这里可以调用Int的方法
        return this - other
    }
    println(1.sub(2))

}