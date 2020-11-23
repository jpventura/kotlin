// TODO: muted for Python because it was muted for JS. Once Python doesn't piggy-back on JS, investigate if it can be re-enabled for Python.
// IGNORE_BACKEND: PYTHON
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR_ES6
// IGNORE_BACKEND: JS, NATIVE
// WITH_REFLECT

import kotlin.reflect.KClass
import kotlin.test.assertEquals

annotation class Anno(
        val klass: KClass<*>,
        val kClasses: Array<KClass<*>>,
        vararg val kClassesVararg: KClass<*>
)

@Anno(String::class, arrayOf(Int::class), Double::class)
fun foo() {}

fun box(): String {
    val k = ::foo.annotations.single() as Anno
    assertEquals(String::class, k.klass)
    assertEquals(Int::class, k.kClasses[0])
    assertEquals(Double::class, k.kClassesVararg[0])
    return "OK"
}
