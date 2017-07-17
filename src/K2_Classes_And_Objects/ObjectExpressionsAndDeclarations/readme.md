### Object expressions

```kotlin

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
var view = View()
view.setCallback(object : Callback() {
    override fun call() {

    }
})

view.setListener(object : Listener {
    override fun onClick() {

    }
})
```

- 如果父类有构造函数，则必须传递相应的构造参数。多个父类可以用逗号隔开，跟
  在冒号后面：
- If a supertype has a constructor, appropriate constructor parameters must be passed to it. Many supertypes may be specified as a comma-separated list after the colon:
```kotlin
open class A(x: Int) {
    public open val y: Int = x
}

interface B {...}

val ab: A = object : A(1), B {
    override val y = 15
}
```

### Note
- Note that anonymous objects can be used as types only in local and private declarations. If you use an anonymous object as a return type of a public function or the type of a public property, the actual type of that function or property will be the declared supertype of the anonymous object, or Any if you didn't declare any supertype. Members added in the anonymous object will not be accessible.

```kotlin
class C {
    // Private function, so the return type is the anonymous object type
    private fun foo() = object {
        val x: String = "x"
    }

    // Public function, so the return type is Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x        // Works
        val x2 = publicFoo().x  // ERROR: Unresolved reference 'x'
    }
}
```

### Object declarations
- 单例模式
```kotlin
object DataProviderManager {
    fun registerDataProvider(provider: DataProvider) {
        // ... obj
    }

    val allDataProviders: Collection<DataProvider>
        get() = // ... obj
}
```

### Companion Objects
```kotlin
class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}

val instance = MyClass.create()
```

- The name of the companion object can be omitted, in which case the name Companion will be used:
```kotlin
class MyClass {
    companion object {
    }
}

val x = MyClass.Companion
```

- Note that, even though the members of companion objects look like static members in other languages, at runtime those are still instance members of real objects, and can, for example, implement interfaces:
  
```kotlin
interface Factory<T> {
    fun create(): T
}


class MyClass {
    companion object : Factory<MyClass> {
        override fun create(): MyClass = MyClass()
    }
}
```
- However, on the JVM you can have members of companion objects generated as real static methods and fields, if you use the @JvmStatic annotation. 

### 对象表达式和声明的区别
- 对象表达式在我们使用的地方立即初始化并执行的
- 对象声明是懒加载的，是在我们第一次访问时初始化的。
- 伴随对象是在对应的类加载时初始化的，和 Java 的静态初始是对应的。