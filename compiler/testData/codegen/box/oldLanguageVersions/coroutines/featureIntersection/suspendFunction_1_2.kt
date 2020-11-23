// TODO: muted for Python because it was muted for JS. Once Python doesn't piggy-back on JS, investigate if it can be re-enabled for Python.
// IGNORE_BACKEND: PYTHON
// !LANGUAGE: -ReleaseCoroutines
// IGNORE_BACKEND: JS_IR, JS
// IGNORE_BACKEND: JS_IR_ES6
// IGNORE_BACKEND: JVM_IR
// WITH_RUNTIME
// WITH_COROUTINES

// some classes are moved from stdlib to compatibility package
// IGNORE_BACKEND: ANDROID

import helpers.*
import kotlin.coroutines.*

val lambda1 = { x: Any -> } as (Any) -> Unit
val suspendLambda0: suspend () -> Unit = {}

fun box(): String {
    assert(lambda1 is SuspendFunction0<*>) { "Failed: lambda1 !is SuspendFunction0<*>" }
    assert(suspendLambda0 is Function1<*, *>) { "Failed: suspendLambda0 is Function1<*, *>" }
    assert(suspendLambda0 is SuspendFunction0<*>) { "Failed: suspendLambda0 is SuspendFunction0<*>" }

    return "OK"
}
