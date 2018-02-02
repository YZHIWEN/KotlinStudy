package K5_FunctionalProgramming

/**
 * Created by yangzhiwen on 17/7/21.
 */


fun main(args: Array<String>) {

    var numbers = listOf(1, -1, 2)
    println(numbers.filter { it > 0 } == listOf(1, 2))
    println(numbers.map { it * it } == listOf(1, 1, 4))

    numbers = listOf(-1, 0, 2)
    val isZero: (Int) -> Boolean = { it == 0 }
    numbers.any(isZero) == true
    numbers.all(isZero) == false
    numbers.count(isZero) == 1
    numbers.find { it > 0 } == 2


    var result = listOf("abc", "12").flatMap { it.toCharArray().toList() }
    println(result)
    result == listOf('a', 'b', 'c', '1', '2')

    listOf(1, 42, 4).max() == 42
    listOf("a", "ab").minBy { it.length } == "a"

    listOf("bbb", "a", "cc").sorted() == listOf("a", "bbb", "cc")
    listOf("bbb", "a", "cc").sortedBy { it.length } == listOf("a", "cc", "bbb")

    groupBy()

    partition()

    fold()
}


fun groupBy() {
    val result = listOf("a", "b", "ba", "ccc", "ad").groupBy { it.length }
    result == mapOf(1 to listOf("a", "b"), 2 to listOf("ba", "ad"), 3 to listOf("ccc"))
}

fun partition() {
    val numbers = listOf(1, 3, -4, 2, -11)
    val (positive, negative) = numbers.partition { it > 0 }
    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)
}

fun fold() {
    listOf(1, 2, 3, 4).fold(1, {
        partProduct, element ->
        element * partProduct
    }) == 24
}