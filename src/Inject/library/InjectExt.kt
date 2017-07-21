package Inject.library

/**
 * Created by yangzhiwen on 17/7/21.
 */

fun <T : Module> T.provide(init: T.() -> Unit): Unit = run(init)

fun <T : Module, OBJ> OBJ.registerModule(module: Module) = ModuleManager.registerModule(module)