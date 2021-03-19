import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    outer@while (scanner.hasNext()) {
        var counter = 0

        for (char in scanner.nextLine().chars()) {
            when (char.toChar()) {
                '(' -> counter++
                ')' -> {
                    counter--
                    if (counter < 0) {
                        println("incorrect")
                        continue@outer
                    }
                }
            }
        }

        println(if (counter == 0) "correct" else "incorrect")
    }
}
