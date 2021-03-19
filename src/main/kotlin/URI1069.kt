package uri1069

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    repeat(scanner.nextLine().toInt()) {
        var line = scanner.nextLine().replace(".", "")
        var diamonds = 0

        while("<>" in line) {
            diamonds++
            line = line.replaceFirst("<>", "")
        }
        println(diamonds)
    }
}
