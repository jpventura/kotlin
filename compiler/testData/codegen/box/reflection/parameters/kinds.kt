// TODO: muted for Python because it was muted for JS. Once Python doesn't piggy-back on JS, investigate if it can be re-enabled for Python.
// IGNORE_BACKEND: PYTHON
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR_ES6
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

// WITH_REFLECT

import kotlin.reflect.full.*
import kotlin.reflect.KParameter.Kind.*
import kotlin.test.assertEquals

class A {
    fun Int.foo(x: String) {}

    inner class Inner(s: String) {}
}

fun box(): String {
    val foo = A::class.memberExtensionFunctions.single()

    assertEquals(listOf(INSTANCE, EXTENSION_RECEIVER, VALUE), foo.parameters.map { it.kind })
    assertEquals(listOf(INSTANCE, VALUE), A::Inner.parameters.map { it.kind })

    return "OK"
}
