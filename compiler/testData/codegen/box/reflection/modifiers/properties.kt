// TODO: muted for Python because it was muted for JS. Once Python doesn't piggy-back on JS, investigate if it can be re-enabled for Python.
// IGNORE_BACKEND: PYTHON
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR_ES6
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

// WITH_REFLECT

import kotlin.test.assertTrue
import kotlin.test.assertFalse

const val const = "const"
val nonConst = "nonConst"

class A {
    lateinit var lateinit: Unit
    var nonLateinit = Unit
}

fun box(): String {
    assertTrue(::const.isConst)
    assertFalse(::nonConst.isConst)

    assertTrue(A::lateinit.isLateinit)
    assertFalse(A::nonLateinit.isLateinit)

    return "OK"
}
