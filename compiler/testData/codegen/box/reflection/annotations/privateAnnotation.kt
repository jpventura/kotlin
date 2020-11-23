// TODO: muted for Python because it was muted for JS. Once Python doesn't piggy-back on JS, investigate if it can be re-enabled for Python.
// IGNORE_BACKEND: PYTHON
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR_ES6
// IGNORE_BACKEND: JS, NATIVE
// WITH_REFLECT

annotation private class Ann(val name: String)

class A {
    @Ann("OK")
    fun foo() {}
}

fun box(): String {
    val ann = A::class.members.single { it.name == "foo" }.annotations.single() as Ann
    return ann.name
}
