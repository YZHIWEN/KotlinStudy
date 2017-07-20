


### Function Literals with Receiver
- kotlin 支持扩展函数。这种方式对于字面函数和表达式函数都是适用的。
- 表达式函数的扩展和普通的区别是它有接收类型的规范。
- 接收类型必须在表达式函数中明确指定，但字面函数不用。字面函数可以作为扩展函数表达式，但只有接收类型可以通过上下文推断出来。

```kotlin
val sum = fun Int.(other: Int): Int = this + other
sum : Int.(other: Int) -> Int

1.sum(2)
1 sum 2
```