### 功能
- Lazy注入
- 注入方式简单，减少依赖
- 实现方式简单，可扩展性高
- 支持键值对属性，支持实体类属性

### 基本框架

![](./arg/inject.png)

##### Module
- 数据提供者，通过Module提供的register提供数据，包括键值对以及对象

#### ModuleManager
- Module管理类，管理Module提供的数据

#### Date Receiver
- 数据接收者，通过指定Module提供的数据，通过lazy代理属性注入，当被注入的属性在被读取的时候才会被初始化赋值

### Usage

- 定义提供数据的Module
```kotlin
class MyModule : Module() {
    override fun onCreate() = provide {
        registerProperty(Person("dazz", 100))
        registerProperty("tag", "this is tag")
        registerProperty("count", 12)
        //... so on
    }
}

class ServiceModule : Module() {
    override fun onCreate() = provide {
        registerProperty(Service())
        //... so on
    }
}
```

- 初始化Module
```kotlin
ModuleManager.registerModule(MyModule())
ModuleManager.registerModule(ServiceModule())
```

- 扩展Inject
```kotlin
/* 扩展Activity的inject方法 */
inline fun <reified V> Activity.inject(key: String): Lazy<V?> = lazy { ModuleManager.getProperty<V>(key) }

inline fun <reified V> Activity.inject(): Lazy<V?> = lazy { ModuleManager.getProperty<V>() }

```

- 注入
```kotlin
class Activity {
    val tag by inject<String>("tag")
    val count by inject<Int>("count")
    val tagChar by inject<Char>("tag")
    val person by inject<Person>()
    val service by inject<Service>()
}
```