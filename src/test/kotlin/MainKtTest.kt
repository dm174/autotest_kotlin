import org.junit.Test

//import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateTransferFee() {


        val transferFee1 = calculateTransferFee("VK Pay", 15000.0, 16000.0)
        val transferFee2 = calculateTransferFee("Visa", 15000.0, 16000.0)
        val transferFee3= calculateTransferFee("Mastercard", 15000.0, 16000.0)
        val transferFee4 = calculateTransferFee("VK Pay", 0.0, 12000.0)
        val transferFee5 = calculateTransferFee("Mastercard", 0.0, 12000.0)
        val transferFee6 = calculateTransferFee("Master", 0.0, 12000.0)
        val transferFee7 = calculateTransferFee("VK Pay", 100_000.0, 12000.0)
    }



}