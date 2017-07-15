package com.ob

import com.dazz.Direction
import com.dazz.fun_in_com_dazz
import fun_in_default_package
import Direction as DefaultDirection


/**
 * Created by Dazz on 2017/7/15.
 */

fun main(args: Array<String>) {
    fun_in_com_dazz()
    fun_in_default_package()
    println(Direction.EAST)
    println(DefaultDirection.EAST)
}