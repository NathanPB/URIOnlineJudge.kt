package uri1110

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    mutableListOf<Int>().also { list ->
        while (scanner.hasNext()) {
            val input = scanner.nextLine().toInt()
            if (input == 0) {
                break
            }
            list.add(input)
        }
    }.map { LinkedList(((0 + 1) .. it).toList()) }.forEach { deck: Queue<Int> ->
        print("Discarded cards: ")
        while (deck.size > 1) {
            val thrown = deck.poll()
            print(if (deck.size > 1) "$thrown, " else thrown)
            deck.offer(deck.poll())
        }
        println("\nRemaining card: ${deck.poll()}")
    }
}
