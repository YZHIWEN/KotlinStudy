@file:Suppress("NOTHING_TO_INLINE")

package uy.kohesive.injekt.api

import java.lang.reflect.Type
import kotlin.reflect.KClass

interface InjektFactory {
    fun <R: Any> getInstance(forType: Type): R
    fun <R: Any> getInstanceOrElse(forType: Type, default: R): R
    fun <R: Any> getInstanceOrElse(forType: Type, default: ()->R): R
    fun <R: Any> getInstanceOrNull(forType: Type): R?

    fun <R: Any, K: Any> getKeyedInstance(forType: Type, key: K): R
    fun <R: Any, K: Any> getKeyedInstanceOrElse(forType: Type, key: K, default: R): R
    fun <R: Any, K: Any> getKeyedInstanceOrElse(forType: Type, key: K, default: ()->R): R
    fun <R: Any, K: Any> getKeyedInstanceOrNull(forType: Type, key: K): R?

    fun <R: Any> getLogger(expectedLoggerType: Type, byName: String): R
    fun <R: Any, T: Any> getLogger(expectedLoggerType: Type, forClass: Class<T>): R
}


inline fun <R: Any> InjektFactory.get(forType: TypeReference<R>): R = getInstance(forType.type)
inline fun <reified R: Any> InjektFactory.getOrElse(forType: TypeReference<R>, default: R): R = getInstanceOrElse(forType.type, default)
inline fun <reified R: Any> InjektFactory.getOrElse(forType: TypeReference<R>, noinline default: ()->R): R = getInstanceOrElse(forType.type, default)
inline fun <reified R: Any> InjektFactory.getOrNull(forType: TypeReference<R>): R? = getInstanceOrNull(forType.type)

inline operator fun <reified R: Any> InjektFactory.invoke(): R = getInstance(fullType<R>().type)
inline fun <reified R: Any> InjektFactory.get(): R = getInstance(fullType<R>().type)
inline fun <reified R: Any> InjektFactory.getOrElse(default: R): R = getInstanceOrElse(fullType<R>().type, default)
inline fun <reified R: Any> InjektFactory.getOrElse(noinline default: ()->R): R = getInstanceOrElse(fullType<R>().type, default)
inline fun <reified R: Any> InjektFactory.getOrNull(): R? = getInstanceOrNull(fullType<R>().type)

inline fun <R: Any> InjektFactory.get(forType: TypeReference<R>, key: Any): R = getKeyedInstance(forType.type, key)
inline fun <reified R: Any> InjektFactory.getOrElse(forType: TypeReference<R>, key: Any, default: R): R = getKeyedInstanceOrElse(forType.type, key, default)
inline fun <reified R: Any> InjektFactory.getOrElse(forType: TypeReference<R>, key: Any, noinline default: ()->R): R = getKeyedInstanceOrElse(forType.type, key, default)
inline fun <reified R: Any> InjektFactory.getOrNull(forType: TypeReference<R>, key: Any): R? = getKeyedInstanceOrNull(forType.type, key)

inline fun <reified R: Any> InjektFactory.get(key: Any): R = getKeyedInstance(fullType<R>().type, key)
inline fun <reified R: Any> InjektFactory.getOrElse(key: Any, default: R): R = getKeyedInstanceOrElse(fullType<R>().type, key, default)
inline fun <reified R: Any> InjektFactory.getOrElse(key: Any, noinline default: ()->R): R = getKeyedInstanceOrElse(fullType<R>().type, key, default)
inline fun <reified R: Any> InjektFactory.getOrNull(key: Any): R? = getKeyedInstanceOrNull(fullType<R>().type, key)

inline fun <R: Any, T: Any> InjektFactory.logger(expectedLoggerType: TypeReference<R>, forClass: Class<T>): R = getLogger(expectedLoggerType.type, forClass)
inline fun <reified R: Any, T: Any> InjektFactory.logger(forClass: Class<T>): R = getLogger(fullType<R>().type, forClass)

inline fun <R: Any, T: Any> InjektFactory.logger(expectedLoggerType: TypeReference<R>, forClass: KClass<T>): R = getLogger(expectedLoggerType.type, forClass.java)
inline fun <reified R: Any, T: Any> InjektFactory.logger(forClass: KClass<T>): R = getLogger(fullType<R>().type, forClass.java)

inline fun <R: Any> InjektFactory.logger(expectedLoggerType: TypeReference<R>, byName: String): R = getLogger(expectedLoggerType.type, byName)
inline fun <reified R: Any> InjektFactory.logger(byName: String): R = getLogger(fullType<R>().type, byName)

inline fun <R: Any> InjektFactory.logger(expectedLoggerType: TypeReference<R>, byObject: Any): R = getLogger(expectedLoggerType.type, byObject.javaClass)
inline fun <reified R: Any> InjektFactory.logger(byObject: Any): R = getLogger(fullType<R>().type, byObject.javaClass)

