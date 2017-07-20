
### Infix notation （ 中间符号 ）

```kotlin
// Define extension to Int
infix fun Int.shl(x: Int): Int {
...
}

// call extension function using infix notation

1 shl 2

// is the same as

1.shl(2)
```

### Unit-returning functions

- If a function does not return any useful value, its return type is Unit. Unit is a type with only one value - Unit. This value does not have to be returned explicitly
```kotlin
fun printHello(name: String?): Unit {
    if (name != null)
        println("Hello ${name}")
    else
        println("Hi there!")
    // `return Unit` or `return` is optional
}

fun printHello(name: String?) {
    ...
}
```

### Single-Expression functions
```kotlin
fun double(x: Int): Int = x * 2

fun double(x: Int) = x * 2
```

### Explicit return types
- Functions with block body must always specify return types explicitly, unless it's intended for them to return Unit
- Kotlin does not infer return types for functions with block bodies because such functions may have complex control flow in the body, and the return type will be non-obvious to the reader (and sometimes even for the compiler).

### Variable number of arguments (Varargs)
```kotlin
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}
```

- If a vararg parameter is not the last one in the list, values for the following parameters can be passed using the named argument syntax, or, if the parameter has a function type, by passing a lambda outside parentheses.

- When we call a vararg-function, we can pass arguments one-by-one, e.g. asList(1, 2, 3), or, if we already have an array and want to pass its contents to the function, we use the spread operator (prefix the array with *):
```kotlin
val a = arrayOf(1, 2, 3)
val list = asList(-1, 0, *a, 4)
```

### Inline Functions
- 使用高阶函数带来了相应的运行时麻烦：每个函数都是一个对象，它捕获闭包，即
  这些变量可以在函数体内被访问。内存的分配，虚拟调用的运行都会带来开销
  但在大多数这种开销是可以通过内联文本函数避免。
- 内联可能会引起生成代码增长，但我们可以合理的解决它(不要内联太大的函数)

### Extension Functions


### noinline  （不是很懂。。。）

- 为了预防 有时候你只希望被（作为参数）传递到一个内联函数的lamdas 只有一些被内联，你可以用 noinline 修饰符标记你的参数:
```kotlin
inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {
  // ...
}
```

- 可以内联的lambdas只能在内联函数内部被调用或者被当作一个可内联的参数传递。 但是通过 noinline 我们可以把它变化成任何的方式：储存在指定地点，传递它等等。

- 需要注意的是，如果一个内联函数没有可以内联的函数参数并且没有 泛型变量, 编译器会产生一个警告。因为内联这样的函数 很可能是无意义的(你可以supress这个警告如果你确定内联是必须的).

### 返回到非局部
```kotlin
fun foo() {
  ordinaryFunction {  // 非内联函数
     return // ERROR: can not make `foo` return here
  }
}

fun foo() {
  inlineFunction { // 内联函数
    return // OK: the lambda is inlined
  }
}
```

- 注意有些内联函数可能会不直接地在函数体中调用那些被作为参数传递过来的lambdas， 而从其他执行上下文中调用，比如一个本地对象或者一个嵌套函数。在这种情况下， non-local的控制流程 也会被lambdas禁止。为了标识这种情况，lambda参数需要 以crossinline 修饰:
```kotlin
inline fun f(crossinline body: () -> Unit) {
    val f = object: Runnable {
        override fun run() = body()
    }
    // ...
}
```

### 泛型变量

```kotlin
inline fun <reified T> TreeNode.findParentOfType(): T? {
    var p = parent
    while (p != null && p !is T) {
        p = p?.parent
    }
    return p as T
}

myTree.findParentOfType<MyTreeNodeType>()
```

```kotlin
inline fun <reified T> membersOf() = T::class.members

fun main(s: Array<String>) {
  println(membersOf<StringBuilder>().joinToString("\n"))
}
```