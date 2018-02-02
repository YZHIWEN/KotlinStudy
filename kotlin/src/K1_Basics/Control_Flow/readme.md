### if

- In Kotlin, if is an expression, i.e. it returns a value. 
- Therefore there is no ternary operator (condition ? then : else), because ordinary if works fine in this role.

```kotlin
// Traditional usage  传统用法
var max = a 
if (a < b) max = b

// With else 传统用法
var max: Int
if (a > b) {
    max = a
} else {
    max = b
}
 
// As expression 
val max = if (a > b) a else b

val max = if (a > b) {
    print("Choose a")
    a
} else {
    print("Choose b")
    b
}
```

```kotlin
fun max(a: Int, b: Int) = if (a > b) a else b
```

### When Expression
- when replaces the switch operator 
```kotlin
when (x) {
    in 1..10 -> print("x is in the range")
    in validNumbers -> print("x is valid")
    !in 10..20 -> print("x is outside the range")
    else -> print("none of the above")
}
```

```kotlin
fun change(x: Int) = when(x) {
  //....
}
```

### For Loops

### While Loops

### Break and continue in loops

http://kotlinlang.org/docs/reference/control-flow.html