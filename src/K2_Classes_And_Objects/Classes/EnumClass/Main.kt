package K2_Classes_And_Objects.Classes.EnumClass

/**
 * Created by Dazz on 2017/7/15.
 */

enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

//Initialization
enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00),
    BLUE(0x0000FF)
}

//Anonymous Classes
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

fun main(args: Array<String>) {
    var res = ProtocolState.valueOf("WAITING")
    println(res)

    println(ProtocolState.values())

    res = ProtocolState.valueOf("12")
    println(res)
}