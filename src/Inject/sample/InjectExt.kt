package Inject.sample

import Inject.library.ModuleManager

/**
 * Created by yangzhiwen on 17/7/21.
 */

inline fun <reified V> Activity.inject(key: String): Lazy<V?> = lazy { ModuleManager.getProperty<V>(key) }

inline fun <reified V> Activity.inject(): Lazy<V?> = lazy { ModuleManager.getProperty<V>() }
