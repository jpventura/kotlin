// TODO: muted for Python because it was muted for JS. Once Python doesn't piggy-back on JS, investigate if it can be re-enabled for Python.
// IGNORE_BACKEND: PYTHON
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR_ES6
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

// WITH_REFLECT

package test

import kotlin.test.assertEquals

fun String?.foo(x: Int, y: Array<Int>, z: IntArray, w: List<Map<Any, A<*>>>) {}

class A<T> {
    fun <U> bar(t: T, u: U): T? = null
}

fun baz(inProjection: A<in Number>, outProjection: A<out Number>) {}

fun box(): String {
    assertEquals(
            listOf(
                    "kotlin.String?",
                    "kotlin.Int",
                    "kotlin.Array<kotlin.Int>",
                    "kotlin.IntArray",
                    "kotlin.collections.List<kotlin.collections.Map<kotlin.Any, test.A<*>>>"
            ),
            String?::foo.parameters.map { it.type.toString() }
    )

    assertEquals("kotlin.Unit", String?::foo.returnType.toString())

    val bar = A::class.members.single { it.name == "bar" }
    assertEquals(listOf("test.A<T>", "T", "U"), bar.parameters.map { it.type.toString() })
    assertEquals("T?", bar.returnType.toString())

    assertEquals(
            listOf("test.A<in kotlin.Number>", "test.A<out kotlin.Number>"),
            ::baz.parameters.map { it.type.toString() }
    )

    return "OK"
}
