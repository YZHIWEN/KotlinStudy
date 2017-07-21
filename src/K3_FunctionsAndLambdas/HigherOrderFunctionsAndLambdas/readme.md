
### Higher-Order Functions
- A higher-order function is a function that takes functions as parameters, or returns a function.

### Lambda expressions
- A lambda expression is always surrounded by curly braces, (总是被 {} 括起来)
- Its parameters (if any) are declared before -> (parameter types may be omitted)
- The body goes after -> (when present)


- In Kotlin, there is a convention that if the last parameter to a function is a function, and you're passing a lambda expression as the corresponding argument, you can specify it outside of parentheses:

```kotlin
fun <T> lock(lock: Lock, body: () -> T): T { 
    // ...
 }

lock (lock) {
    sharedResource.operation()
}
```

#### it: implicit name of a single parameter
```kotlin
ints.map { it * 2 }

strings.filter { it.length == 5 }.sortBy { it }.map { it.toUpperCase() }
```

#### Underscore for unused variables (since 1.1)
- If the lambda parameter is unused, you can place an underscore instead of its name:
```kotlin
map.forEach { _, value -> println("$value!") }
```

### Lambda Expression Syntax
-  If the inferred return type of the lambda is not Unit, the last (or possibly single) expression inside the lambda body is treated as the return value.
```kotlin
val sum = { x: Int, y: Int -> x + y }

val sum: (Int, Int) -> Int = { x, y -> x + y }
```


- We can explicitly return a value from the lambda using the qualified return syntax. Otherwise, the value of the last expression is implicitly returned
```kotlin
ints.filter {
    val shouldFilter = it > 0 
    shouldFilter
}

ints.filter {
    val shouldFilter = it > 0 
    return@filter shouldFilter
}
```

### Closures
- A lambda expression or anonymous function (as well as a local function and an object expression) can access its closure, i.e. the variables declared in the outer scope. Unlike Java, the variables captured in the closure can be modified:
```kotlin
var sum = 0
ints.filter { it > 0 }.forEach {
    sum += it
}
print(sum)
```

### Function Literals with Receiver

- Kotlin provides the ability to call a function literal with a specified receiver object. Inside the body of the function literal, you can call methods on that receiver object without any additional qualifiers. 
- Kotlin提供字面函数跟随着一个接受者，在函数body可以调用该接受者的其他函数和属性。
```kotlin
// 这里Int是接受者
sum : Int.(other: Int) -> Int
1.sum(2)

val sub = fun Int.(other: Int): Int {
    println("call Int fun : " + toByte()) // 这里接受者是Int，这里可以调用Int的方法
    return this - other
}
println(1.sub(2))
```

- This is similar to extension functions, which allow you to access members of the receiver object inside the body of the function. 
-  One of the most important examples of their usage is Type-safe Groovy-style builders


```kotlin

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

// 这里其实就是调用html方法，传入lambda表达式，在这个lambda表达式的接受者是HTML，所以可以调用HTML的方法，这个lambda表达式在html方法中被调用也就是init方法
html {       // lambda with receiver begins here
    body()   // calling a method on the receiver object
}
```

#### Builder模式
```kotlin
fun <T> T.build(create: T.() -> Unit): T {
    create()
    return this
}

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


Config().build {
    setCount(111)
    setOther("build other")
    setTag("build tag")
    // ...
    providerFun {
        println("provided callback")
    }
}
```

