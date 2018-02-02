package N6_Generic

/**
 * Created by Dazz on 2017/7/8.
 */

// out String 相当于 T extends String
fun main(args: Array<out String>) {

    var list= arrayListOf<String>()
    list.add("a")
    list.add("b")
    list.add("c")
    list.add("d")

    // map传入lambda表达式，()无参数时可省略
    // 函数最后一个参数为lambda表达式则可以将{}移到()外面
    // ::println相当于lambda表达式，方法引用
    list.map() {
        println(it)
    }

    list.map {
        println(it)
    }

    list.map(::println)
}


