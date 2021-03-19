import org.junit.jupiter.api.Test
import uri1083.main

class URI1083 {

    @Test
    fun `left parenthesis`() {
        assertEqualsWithInput("Syntax Error!\n", "(",  ::main)
    }

    @Test
    fun `left parenthesis with operand and operator`() {
        assertEqualsWithInput("Syntax Error!\n", "(A+", ::main)
    }

    @Test
    fun `parenthesis operation and operation`() {
        assertEqualsWithInput("abc*+2/e*a+\n", "(a+b*c)/2*e+a.", ::main)
    }

    @Test
    fun `operation with invalid character`() {
        assertEqualsWithInput("Lexical Error!\n", "(A+B)*%", ::main)
    }

    @Test
    fun `complex operation`() {
        assertEqualsWithInput("abc*+2/e*a+\n", "(a+b*c)/2*e+a", ::main)
    }

    @Test
    fun `complex operation with tho parenthesis block in the same scope`() {
        assertEqualsWithInput("abc*+2/ea+*\n", "(a+b*c)/2*(e+a)", ::main)
    }

    @Test
    fun `invalid syntax operation`() {
        assertEqualsWithInput("Syntax Error!\n", "(a+b*c)/2*(e+a", ::main)
    }

    @Test
    fun `invalid syntax operation2`() {
        assertEqualsWithInput("Syntax Error!\n", "(ab+*c)/2*(e+a)", ::main)
    }

    @Test
    fun `invalid syntax operation3`() {
        assertEqualsWithInput("Syntax Error!\n", "(a+b*cc)/2*(e+a", ::main)
    }

    @Test
    fun `complex operation with invalid character`() {
        assertEqualsWithInput("Lexical Error!\n", "(“a+b*cc)/2*(e+a", ::main)
    }

    @Test
    fun `simple operation`() {
        assertEqualsWithInput("ab+c-\n", "a+b-c", ::main)
    }

    @Test
    fun `simple operation but a bit longer`() {
        assertEqualsWithInput("abc*d/-e+\n", "a-b*c/d+e", ::main)
    }

}
