// TODO: muted for Python because it was muted for JS. Once Python doesn't piggy-back on JS, investigate if it can be re-enabled for Python.
// IGNORE_BACKEND: PYTHON
// IGNORE_BACKEND: JS_IR, JS, NATIVE
// IGNORE_BACKEND: JS_IR_ES6
// WITH_REFLECT
package test

import kotlin.test.assertEquals

interface I1 {
    fun f()
    val x: Int
}

interface I2 {
    fun f()
    val x: Int
}

interface I3 {
    fun f()
    val x: Int
}

interface I : I2, I1, I3

fun box(): String {
    assertEquals("fun test.I.f(): kotlin.Unit", I::f.toString())
    assertEquals("val test.I.x: kotlin.Int", I::x.toString())

    val f = I::class.members.single { it.name == "f" }
    assertEquals("fun test.I.f(): kotlin.Unit", f.toString())
    val x = I::class.members.single { it.name == "x" }
    assertEquals("val test.I.x: kotlin.Int", x.toString())

    return "OK"
}
