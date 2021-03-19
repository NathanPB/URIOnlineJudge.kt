import org.junit.jupiter.api.Assertions
import java.io.*

fun assertEqualsWithInput(expected: String, input: String, func: (Array<String>) -> Unit) {
    Assertions.assertEquals(expected, runWithInput(input, func))
}

fun runWithInput(content: String, func: (Array<String>)->Unit): String {
    return withInput(content) {
        func(emptyArray())
    }
}

fun withInput(content: String, block: ()->Unit): String {
    val defaultIn = System.`in`
    val defaultOut = System.out

    try {
        val out = ByteArrayOutputStream()

        System.setIn(ByteArrayInputStream(content.toByteArray()))
        System.setOut(PrintStream(out))

        block()

        return out.toByteArray().decodeToString()
    } finally {
        System.setIn(defaultIn)
        System.setOut(defaultOut)
    }
}
