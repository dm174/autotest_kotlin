import org.junit.Assert.*
import org.junit.Test

class MainKtTest1
{
    @Test
    fun main() {

        val transferFee7 = calculateTransferFee("VK Pay", 100_000.0, 12000.0)
        assertEquals(-2.0,transferFee7,0.001)
    }
}