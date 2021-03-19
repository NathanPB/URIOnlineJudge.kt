import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Utils {

    @Test
    fun `should pipe the input to stdin and return stdout`() {
        Assertions.assertEquals("bondia", withInput("bondia") { System.`in`.copyTo(System.out) })
    }

    @Test
    fun `should pipe the input to stdin and return stdout 2`() {
        Assertions.assertEquals("bondia", runWithInput("bondia") { System.`in`.copyTo(System.out) })
    }
}
