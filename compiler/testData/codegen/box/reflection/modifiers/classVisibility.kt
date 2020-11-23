// TODO: muted for Python because it was muted for JS. Once Python doesn't piggy-back on JS, investigate if it can be re-enabled for Python.
// IGNORE_BACKEND: PYTHON
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR_ES6
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

// WITH_REFLECT

import kotlin.reflect.KClass
import kotlin.reflect.KVisibility
import kotlin.test.assertEquals

class DefaultVisibilityClass
public class PublicClass {
    protected class ProtectedClass
    fun getProtectedClass(): KClass<*> = ProtectedClass::class
}
internal class InternalClass
private class PrivateClass

fun box(): String {
    assertEquals(KVisibility.PUBLIC, DefaultVisibilityClass::class.visibility)
    assertEquals(KVisibility.PUBLIC, PublicClass::class.visibility)
    assertEquals(KVisibility.PROTECTED, PublicClass().getProtectedClass().visibility)
    assertEquals(KVisibility.INTERNAL, InternalClass::class.visibility)
    assertEquals(KVisibility.PRIVATE, PrivateClass::class.visibility)

    class Local
    assertEquals(null, Local::class.visibility)

    val anonymous = object {}
    assertEquals(null, anonymous::class.visibility)

    return "OK"
}
