// TODO: muted for Python because it was muted for JS. Once Python doesn't piggy-back on JS, investigate if it can be re-enabled for Python.
// IGNORE_BACKEND: PYTHON
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR_ES6
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

// WITH_REFLECT

fun foo(result: String = "OK") = result

fun box(): String = ::foo.callBy(mapOf())
