package N5_CallableReferences

/**
 * Created by Dazz on 2017/7/5.
 */


fun isOdd(x: Int) = x % 2 != 0

fun length(s: String) = s.length

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}


fun main(args: Array<String>) {

    /**
     * "Callable References" or "Feature Literals", i.e. an ability to pass
     * named functions or properties as values. Users often ask
     * "I have a foo() function, how do I pass it as an argument?".
     * The answer is: "you prefix it with a `::`".
     */
    val numbers = listOf(1, 2, 3)
    println(numbers.filter(::isOdd))


    /**
     * The composition function return a composition of two functions passed to it:
     * compose(f, g) = f(g(*)).
     * Now, you can apply it to callable references.
     */
    val oddLength = compose(::isOdd, ::length)
    val strs = listOf("a","aa","aaa","aaaa")
    println(strs.filter(oddLength))
}