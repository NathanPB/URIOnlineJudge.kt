import org.junit.jupiter.api.Test
import uri1086.main

class URI1068 {

    @Test
    fun `test case 1`() {
        assertEqualsWithInput("correct\n", "a+(b*c)-2-a", ::main)
    }

    @Test
    fun `test case 2`() {
        assertEqualsWithInput("correct\n", "(a+b*(2-c)-2+a)*2 ", ::main)
    }

    @Test
    fun `test case 3`() {
        assertEqualsWithInput("incorrect\n", "(a*b-(2+c) ", ::main)
    }

    @Test
    fun `test case 4`() {
        assertEqualsWithInput("incorrect\n", "2*(3-a))  ", ::main)
    }

    @Test
    fun `test case 5`() {
        assertEqualsWithInput("incorrect\n", ")3+b*(2-c)( ", ::main)
    }

}
