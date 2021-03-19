import java.util.*

/*
 * This algorithm still doesn't pass in the URI platform, but it parses the entire expression into an expression tree.
 * TODO: format the tree to postfix format and print
 */

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val operators = listOf('^', '*', '/', '+', '-', '>', '<', '=', '#', '.', '|')
    val operands = "[a-zA-Z0-9]+".toRegex()

    abstract class Expression {
        abstract fun postfix(): String
    }
    class OperandExpression(val left: Expression, val operator: Char, val right: Expression) : Expression() {
        override fun toString() = "exp($left $operator $right)"
        override fun postfix() = "${left.postfix()}${right.postfix()}$operator"
    }
    class ConstantExpression(val value: String) : Expression() {
        override fun toString() = value
        override fun postfix() = toString()
    }

    fun parseExpression(expression: String) : Expression {
        return if (expression.matches(operands)) {
            ConstantExpression(expression)
        } else {
            val expressionCount = run {
                var depth = 0
                var expressionCount = 0
                for (char in expression.toCharArray()) {
                    if (char == '(') depth++
                    if (char == ')')  {
                        depth--
                        if (depth == 0) {
                            expressionCount++
                        }
                    }
                }
                expressionCount
            }

            if (expression.startsWith('(') && expression.endsWith(')') && expressionCount == 1) {
                val startIndex = expression.indexOf('(')

                val (_, endIndex) = expression
                    .substring(startIndex)
                    .toCharArray()
                    .asList()
                    .foldRightIndexed(1 to -1) { index, char, acc ->
                        val (depth) = acc
                        if (depth > 0) {
                            when (char) {
                                '(' -> depth+1 to index
                                ')' -> depth-1 to index
                                else -> depth to index
                            }
                        } else acc
                    }

                parseExpression(expression.substring(startIndex+1, startIndex+endIndex))
            } else {
                var depth = 0
                val index = expression.mapIndexedNotNull { index, it ->
                    if (it == '(') depth++
                    if (it == ')') depth--

                    if (depth == 0) {
                        val operator = operators.firstOrNull(it::equals)
                        if (operator != null) {
                            return@mapIndexedNotNull index as Int?
                        }
                    }
                    return@mapIndexedNotNull null as Int?
                }.maxByOrNull { operators.indexOf(expression[it]) } ?: error("Syntactical Error")

                val left = expression.take(index)
                val right = expression.substring(index + 1)
                if (left.isBlank() || right.isBlank()) {
                    error("Syntactical Error")
                }
                OperandExpression(parseExpression(left), expression[index], parseExpression(right))
            }

        }
    }

    while (scanner.hasNext()) {
        val expression = scanner.nextLine().replace(" ", "")
        try {
            if (!expression.all { it == '(' || it == ')' || it in operators || it.toString().matches(operands) }) {
                error("Lexical Error")
            }

            println(parseExpression(expression).postfix())
        } catch (e: IllegalStateException) {
            println(e.message)
        }
    }
}
