// KT-55828
// IGNORE_BACKEND_K2: NATIVE
// SKIP_MANGLE_VERIFICATION
interface Callback {
    fun invoke(): String
}

enum class Foo(
        val x: String,
        val callback: Callback
) {
    FOO(
            "OK",
            object : Callback {
                override fun invoke() = FOO.x
            }
    )
}

fun box() = Foo.FOO.callback.invoke()