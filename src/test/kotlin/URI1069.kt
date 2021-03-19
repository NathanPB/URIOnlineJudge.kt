import org.junit.jupiter.api.Test
import uri1069.main

class URI1069 {

    @Test
    fun `test case from uri`() {
        assertEqualsWithInput(
            "3\n1\n",
            "2\n<..><.<..>>\n<<<..<......<<<<....>\n",
            ::main
        )
    }
}
