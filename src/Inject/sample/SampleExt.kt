package Inject.sample

import Inject.library.ModuleManager

/**
 * Created by yangzhiwen on 17/7/21.
 */

/**
 *  扩展Activity的inject方法
 */
inline fun <reified V> Activity.inject(key: String): Lazy<V?> = lazy { ModuleManager.getProperty<V>(key) }

inline fun <reified V : Any> Activity.inject(): Lazy<V?> = lazy { ModuleManager.getProperty<V>() }
