// TODO: muted for Python because it was muted for JS. Once Python doesn't piggy-back on JS, investigate if it can be re-enabled for Python.
// IGNORE_BACKEND: PYTHON
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR_ES6
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

// WITH_REFLECT

import kotlin.reflect.full.*

open class A {
    fun mem() {}
    fun Int.memExt() {}
}

class B : A()

fun box(): String {
    val all = A::class.functions.map { it.name }.sorted()
    assert(all == listOf("equals", "hashCode", "mem", "memExt", "toString")) { "Fail A functions: ${A::class.functions}" }

    val declared = A::class.declaredFunctions.map { it.name }.sorted()
    assert(declared == listOf("mem", "memExt")) { "Fail A declaredFunctions: ${A::class.declaredFunctions}" }

    val declaredSubclass = B::class.declaredFunctions.map { it.name }.sorted()
    assert(declaredSubclass.isEmpty()) { "Fail B declaredFunctions: ${B::class.declaredFunctions}" }

    return "OK"
}
