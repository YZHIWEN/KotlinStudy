### Inheritance

- All classes in Kotlin have a common superclass Any,
Any is not java.lang.Object; in particular, it does not have any members other than equals(), hashCode() and toString()


- The open annotation on a class is the opposite of Java's final: it allows others to inherit from this class. By default, all classes in Kotlin are final, which corresponds to Effective Java, Item 17: Design and document for inheritance or else prohibit it.

- If the class has a primary constructor, the base type can (and must) be initialized right there, using the parameters of the primary constructor.

- If the class has no primary constructor, then each secondary constructor has to initialize the base type using the super keyword, or to delegate to another constructor which does that.

```
// need open keyword
open class Animal constructor(name: String)

// has primary constructor
class Cat(name: String, age: Int) : Animal(name)

// no primary constructor
class Dog : Animal {
    constructor(name: String, age: Int) : super(name){

    }
}
```

### Overriding Methods
- stick to making things explicit in Kotlin. And unlike Java, Kotlin requires explicit annotations for overridable members (we call them open) and for overrides:
```
open class Base {
    open fun v() {}
    fun nv() {}
}
class Derived() : Base() {
    override fun v() {}
}
```
- A member marked override is itself open, i.e. it may be overridden in subclasses. If you want to prohibit re-overriding, use final:
```
open class AnotherDerived() : Base() {
    final override fun v() {}
}
```

### Overriding Properties

- Each declared property can be overridden by a property with an initializer or by a property with a getter method.
- 可以重写属性的初始化值或者getter方法
- You can also override a val property with a var property, but not vice versa. This is allowed because a val property essentially declares a getter method, and overriding it as a var additionally declares a setter method in the derived class.

```
open class Animal constructor(name: String){
    open val tag = "Animal"
    open var id = "1"
    open fun eat(){
        println("Animal eat")
    }
}

class Cat(name: String, age: Int) : Animal(name){
    override val tag = "Cat"
    override var id: String
        get() = "Cat: "+super.id
        set(value) {
            this.id = "Cat: "+value
        }

    override fun eat() {
        println("Cat eat")
    }
}

class Dog : Animal {
    override val tag: String
        get() = "Dog Tag"

    constructor(name: String, age: Int) : super(name){

    }

    override fun eat() {
        println("Dog eat")
    }
}
```

### Overriding Rules
-  if a class inherits many implementations of the same member from its immediate superclasses, it must override this member and provide its own implementation (perhaps, using one of the inherited ones). To denote the supertype from which the inherited implementation is taken, we use super qualified by the supertype name in angle brackets, e.g. super<Base>:
- 对于继承多个实现中有冲突的方法，需要重写，并通过super<T>指向父类T
```
open class A {
    open fun f() { print("A") }
    fun a() { print("a") }
}

interface B {
    fun f() { print("B") } // interface members are 'open' by default
    fun b() { print("b") }
}

class C() : A(), B {
    // The compiler requires f() to be overridden:
    override fun f() {
        super<A>.f() // call to A.f()
        super<B>.f() // call to B.f()
    }
}
```

### Abstract Class
- A class and some of its members may be declared abstract. An abstract member does not have an implementation in its class. Note that we do not need to annotate an abstract class or function with open – it goes without saying.
```
open class Base {
    open fun f() {}
}

abstract class Derived : Base() {
    override abstract fun f()
}
```