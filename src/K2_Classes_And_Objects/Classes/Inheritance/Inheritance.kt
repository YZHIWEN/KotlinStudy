package K2_Classes_And_Objects.Classes.Inheritance

/**
 * Created by Dazz on 2017/7/15.
 */


//The open annotation on a class is the opposite of Java's final: it allows others to inherit from this class. By default, all classes in Kotlin are final, which corresponds to Effective Java, Item 17: Design and document for inheritance or else prohibit it.
open class Animal constructor(name: String){
    open val tag = "Animal"
    open var id = "1"
    open fun eat(){
        println("Animal eat")
    }
}

//If the class has a primary constructor, the base type can (and must) be initialized right there, using the parameters of the primary constructor.
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

//If the class has no primary constructor, then each secondary constructor has to initialize the base type using the super keyword, or to delegate to another constructor which does that.
class Dog : Animal {
    override val tag: String
        get() = "Dog Tag"

    constructor(name: String, age: Int) : super(name){

    }

    override fun eat() {
        println("Dog eat")
    }
}

fun main(args: Array<String>) {
    val animal = Animal("dazz")
    println(animal.tag)
    println(animal.id)
    println()

    val cat = Cat("dazz cat",1)
    println(cat.tag)
    println(cat.id)
    println()

    val dog = Dog("dazz dog",2)
    println(dog.tag)
    println(dog.id)
    println()
}