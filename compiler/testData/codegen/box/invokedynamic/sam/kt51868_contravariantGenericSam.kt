// IGNORE_BACKEND_K2: JVM_IR, JS_IR
// FIR status: "ClassCastException: String cannot be cast to StringBuilder".
// FIR always takes the parameter type and erases type projections in it to obtain the SAM type. This is incorrect, see KT-51868 and KT-52428.

// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8
// WITH_STDLIB

// CHECK_BYTECODE_TEXT
// JVM_IR_TEMPLATES
// 0 java/lang/invoke/LambdaMetafactory

// FILE: box.kt

fun box(): String {
    var result = "Fail"
    val r = Request { obj: CharSequence ->
        result = obj as String
    }
    r.deliver("OK")
    return result
}

// FILE: Request.java

public class Request {
    private final Consumer<? super StringBuilder> consumer;

    public Request(Consumer<? super StringBuilder> consumer) {
        this.consumer = consumer;
    }

    public void deliver(Object response) {
        deliverResponse(consumer, response);
    }

    public <K extends CharSequence> void deliverResponse(final Consumer<K> consumer, Object rawResponse) {
        K response = (K) rawResponse;
        consumer.accept(response);
    }
}

// FILE: Consumer.java

public interface Consumer<T extends CharSequence> {
    void accept(T t);
}
