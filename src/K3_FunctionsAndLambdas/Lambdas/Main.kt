package K3_FunctionsAndLambdas.Lambdas

/**
 * Created by yangzhiwen on 17/7/20.
 */

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

fun main(args: Array<String>) {
    Config().build {
        setCount(111)
        setOther("build other")
        setTag("build tag")
        // ...
        providerFun {
            println("provided callback")
        }
    }
}