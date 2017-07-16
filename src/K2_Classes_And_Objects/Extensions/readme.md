### Extensions
- Kotlin, similar to C# and Gosu, provides the ability to extend a class with new functionality without having to inherit from the class or use any type of design pattern such as Decorator. This is done via special declarations called extensions. Kotlin supports extension functions and extension properties.

### Extensions Functions

```kotlin
//  adds a swap function to MutableList<Int>
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}
```
- The this keyword inside an extension function corresponds to the receiver object (the one that is passed before the dot).

- Extensions do not actually modify classes they extend. By defining an extension, you do not insert new members into a class, but merely make new functions callable with the dot-notation on variables of this type.
  
### Extensions are resolved statically (扩展程序被静态解析)
- This means that the extension function being called is determined by the type of the expression on which the function is invoked, **not by the type of the result of evaluating that expression at runtime.**

```kotlin
open class C
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

// run
printlnFoo(C())
printlnFoo(D())
printlnFoo(E())

// result:
C.foo()
C.foo()
C.foo()
```
- If a class has a member function, and an extension function is defined which has the same receiver type, the same name and is applicable to given arguments, the member always wins.
```kotlin
class C {
    fun foo() { println("member") }
}

fun C.foo() { println("extension") }
// member
```

### Nullable Receiver
- 不是很懂？

```kotlin
fun Any?.toString(): String {
    if (this == null) return "null"
    // after the null check, 'this' is autocast to a non-null type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}
```



### Extension Properties

- Note that, since extensions do not actually insert members into classes, there's no efficient way for an extension property to have a backing field. This is why initializers are not allowed for extension properties. Their behavior can only be defined by explicitly providing getters/setters.
- 不是很懂? 

### Companion Object Extensions

```kotlin
class MyClass {
    companion object { }  // will be called "Companion"
}

fun MyClass.Companion.foo() {
    // ...
}

// 注意这里不是MyClass().foo()
MyClass.foo()
```

### Scope of Extensions
- http://kotlinlang.org/docs/reference/extensions.html#scope-of-extensions

### Declaring Extensions as Members

```kotlin
class D {
    fun bar() { ... }
}

class C {
    fun baz() { ... }

    fun D.foo() {
        bar()   // calls D.bar
        baz()   // calls C.baz
    }

    fun caller(d: D) {
        d.foo()   // call the extension function
    }
}
```

```kotlin
class C {
    fun D.foo() {
        toString()         // calls D.toString()
        this@C.toString()  // calls C.toString()
    }
}
```

```kotlin
open class D {
}

class D1 : D() {
}

open class C {
    open fun D.foo() {
        println("D.foo in C")
    }

    open fun D1.foo() {
        println("D1.foo in C")
    }

    fun caller(d: D) {
        d.foo()   // call the extension function
    }
}

class C1 : C() {
    override fun D.foo() {
        println("D.foo in C1")
    }

    override fun D1.foo() {
        println("D1.foo in C1")
    }
}

C().caller(D())   // prints "D.foo in C"
C1().caller(D())  // prints "D.foo in C1" - dispatch receiver is resolved virtually
C().caller(D1())  // prints "D.foo in C" - extension receiver is resolved statically
```