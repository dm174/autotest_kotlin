import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateTransferFee() {


        val transferFee1 = calculateTransferFee("VK Pay", 15000.0, 16000.0)

        assertEquals(-1.0,transferFee1,0.001)
    }
    @Test
    fun calculateTransferFee2() {

        val transferFee2 = calculateTransferFee("Visa", 15000.0, 16000.0)
        assertEquals(120.0,transferFee2,0.001)
    }
    @Test
    fun calculateTransferFee3() {

        val transferFee3= calculateTransferFee("Mastercard", 15000.0, 16000.0)
        assertEquals(0.0,transferFee3,0.001)
    }

    @Test
    fun calculateTransferFee4() {

        val transferFee4 = calculateTransferFee("VK Pay", 0.0, 12000.0)
        assertEquals(0.0,transferFee4,0.001)
    }
    @Test
    fun calculateTransferFee5() {

        val transferFee5 = calculateTransferFee("Mastercard", 0.0, 12000.0)

    }
    @Test
    fun calculateTransferFee6() {

        val transferFee6 = calculateTransferFee("Master", 0.0, 12000.0)
        assertEquals(1.0,transferFee6,0.001)
    }


    @Test
    fun calculateTransferFee7() {

        val transferFee7 = calculateTransferFee("VK Pay", 100_000.0, 12000.0)
       assertEquals(-2.0,transferFee7,0.001)

    }

    @Test
    fun main1() {

        val main1 = main()

    }}
    }

    @Test
    fun calculateTransferFee8() {

        val transferFee8= calculateTransferFee("Mastercard", 105000.0, 160000.0)
        //assertEquals(1.0,transferFee8,0.001)
    }


}