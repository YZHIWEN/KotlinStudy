package K2_Classes_And_Objects.Delegation

/**
 * Created by Dazz on 2017/7/18.
 */

val lazyValue: String by lazy {
    println("lazyValue")
    "value"
}


fun main(args: Array<String>) {

    println(lazyValue)
    println(lazyValue)

}