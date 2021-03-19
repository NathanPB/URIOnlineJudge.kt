import org.junit.jupiter.api.Test
import uri1110.main

class URI1110 {

    @Test
    fun `test case 1`() {
        assertEqualsWithInput(
            "Discarded cards: 1, 3, 5, 7, 4, 2\nRemaining card: 6\n",
            "7\n0\n",
            ::main
        )
    }

    @Test
    fun `test case 2`() {
        assertEqualsWithInput(
            "Discarded cards: 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 4, 8, 12, 16, 2, 10, 18, 14\nRemaining card: 6\n",
            "19\n0\n",
            ::main
        )
    }

    @Test
    fun `test case 3`() {
        assertEqualsWithInput(
            "Discarded cards: 1, 3, 5, 7, 9, 2, 6, 10, 8\nRemaining card: 4\n",
            "10\n0\n",
            ::main
        )
    }

    @Test
    fun `test case 4`() {
        assertEqualsWithInput(
            "Discarded cards: 1, 3, 5, 2, 6\nRemaining card: 4\n",
            "6\n0\n",
            ::main
        )
    }

}
