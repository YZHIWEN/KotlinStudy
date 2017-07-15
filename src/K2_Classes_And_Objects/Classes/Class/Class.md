### Class

#### 组成

- class name
- class header(optional):( type parameters, primary constructor )
- class body(optional)

```kotlin
class Empty

class Person constructor(name:String)


class Customer(name: String){
    val key = name.toUpperCase()

//    initializer blocks,
    init {
        println("Customer name : $name")
    }
}
```

- If the constructor has annotations or visibility modifiers, the constructor keyword is required, and the modifiers go before it:
```kotlin
class P private @Inject constructor(name: String)
```

#### Constructors

##### Primary Constructors
- 见上文

##### Secondary Constructors
- no primary constructors
```kotlin
class Love {
    constructor(name: String) {
    }
}
```
- has primary constructors
    - If the class has a primary constructor, each secondary constructor needs to delegate to the primary constructor, either directly or indirectly through another secondary constructor(s)
```kotlin
class MyLove(name: String) {
    constructor(name: String, age: Int) : this(name) {
    }
}
```

### Nested Classes

#### Nested Classes & Inner classes
```kotlin
class Outer{
    private val bar = 1
    class Nested{
        fun foo() = 2
    }

    inner class Inner{
        fun foo() = bar
    }
}

Outer.Nested().foo()
Outer().Inner().foo()
```

#### Anonymous inner classes
- Anonymous inner class instances are created using an **object expression**

### Class Members
Classes can contain
- Constructors and initializer blocks
- Functions
- Properties
- Nested and Inner Classes
- Object Declarations