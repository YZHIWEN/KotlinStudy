package K2_Classes_And_Objects.Extensions

/**
 * Created by Dazz on 2017/7/16.
 */

data class Person(var firstName: String, var secondName: String)

fun Person.swap() {
    val temp = this.firstName
    this.firstName = this.secondName
    this.secondName = temp
}

open class C {
    var id: Int = 1
        get() = field
        set(value) {
            field = value
        }

    fun haha() {
        println("C member")
    }
}

fun C.haha() {
    println("C extensions")
}

class D : C()
class E : C()

fun C.foo() {
    println("C.foo()")
}

fun D.foo() {
    println("D.foo()")
}

fun printlnFoo(c: C) {
    c.foo()
}

val C.count: Int
    get() = 1


class MyClass {
    companion object { }  // will be called "Companion"
}


fun MyClass.Companion.foo() {
    println("MyClass Companion foo()")
}

fun main(args: Array<String>) {
    val p = Person("11", "22")
    println(p)
    p.swap()
    println(p)

    println("===========================")

    printlnFoo(C())
    printlnFoo(D())
    printlnFoo(E())

    println("===========================")

    println(C().count)

    println("===========================")

    var c = C()
    println(c.id)
    c.id = 112
    println(c.id)

    println("===========================")

    MyClass.foo()
}