package solutions.CHK

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CheckoutSolutionTest {

    @Test
    fun combinedSkus() {
        Assertions.assertEquals(145, CheckoutSolution.checkout("ABCDDD"))
        Assertions.assertEquals(220, CheckoutSolution.checkout("BBBBAAA"))
        Assertions.assertEquals(170, CheckoutSolution.checkout("FFFAAAC"))
    }

    @Test
    fun basicItemsOnly() {
        Assertions.assertEquals(20, CheckoutSolution.checkout("C"))
        Assertions.assertEquals(15, CheckoutSolution.checkout("D"))
        Assertions.assertEquals(20, CheckoutSolution.checkout("G"))
        Assertions.assertEquals(35, CheckoutSolution.checkout("I"))
        Assertions.assertEquals(60, CheckoutSolution.checkout("J"))
        Assertions.assertEquals(90, CheckoutSolution.checkout("L"))
        Assertions.assertEquals(15, CheckoutSolution.checkout("M"))
        Assertions.assertEquals(10, CheckoutSolution.checkout("O"))
        Assertions.assertEquals(30, CheckoutSolution.checkout("S"))
        Assertions.assertEquals(20, CheckoutSolution.checkout("T"))
        Assertions.assertEquals(20, CheckoutSolution.checkout("W"))
        Assertions.assertEquals(90, CheckoutSolution.checkout("X"))
        Assertions.assertEquals(10, CheckoutSolution.checkout("Y"))
        Assertions.assertEquals(50, CheckoutSolution.checkout("Z"))
    }

    @Test
    fun invalidInputs() {
        Assertions.assertEquals(-1, CheckoutSolution.checkout("A9"))
        Assertions.assertEquals(-1, CheckoutSolution.checkout("!"))
        Assertions.assertEquals(-1, CheckoutSolution.checkout("abcd"))
    }

    // multiple same items tests
    @Test
    fun offerMultipleItemsDiscount() {
        Assertions.assertEquals(50, CheckoutSolution.checkout("A"))
        Assertions.assertEquals(180, CheckoutSolution.checkout("AAAA"))
        Assertions.assertEquals(250, CheckoutSolution.checkout("AAAAAA"))
        Assertions.assertEquals(330, CheckoutSolution.checkout("AAAAAAAA"))

        Assertions.assertEquals(30, CheckoutSolution.checkout("B"))
        Assertions.assertEquals(45, CheckoutSolution.checkout("BB"))
        Assertions.assertEquals(90, CheckoutSolution.checkout("BBBB"))

        Assertions.assertEquals(10, CheckoutSolution.checkout("H"))
        Assertions.assertEquals(40, CheckoutSolution.checkout("HHHH"))
        Assertions.assertEquals(45, CheckoutSolution.checkout("HHHHH"))
        Assertions.assertEquals(65, CheckoutSolution.checkout("HHHHHHH"))
        Assertions.assertEquals(80, CheckoutSolution.checkout("HHHHHHHHHH"))

        Assertions.assertEquals(80, CheckoutSolution.checkout("K"))
        Assertions.assertEquals(150, CheckoutSolution.checkout("KK"))

        Assertions.assertEquals(50, CheckoutSolution.checkout("P"))
        Assertions.assertEquals(200, CheckoutSolution.checkout("PPPPP"))

        Assertions.assertEquals(30, CheckoutSolution.checkout("Q"))
        Assertions.assertEquals(80, CheckoutSolution.checkout("QQQ"))

        Assertions.assertEquals(50, CheckoutSolution.checkout("V"))
        Assertions.assertEquals(90, CheckoutSolution.checkout("VV"))
        Assertions.assertEquals(130, CheckoutSolution.checkout("VVV"))
    }


    @Test
    fun offerGetDifferentOneFree() {
        Assertions.assertEquals(40, CheckoutSolution.checkout("E"))
        Assertions.assertEquals(80, CheckoutSolution.checkout("EE"))
        Assertions.assertEquals(80, CheckoutSolution.checkout("EEB"))
        Assertions.assertEquals(110, CheckoutSolution.checkout("EEBB"))
        Assertions.assertEquals(160, CheckoutSolution.checkout("EEEEBB"))
        Assertions.assertEquals(160, CheckoutSolution.checkout("EEEEB"))
        Assertions.assertEquals(190, CheckoutSolution.checkout("EEEEBBB"))

        Assertions.assertEquals(40, CheckoutSolution.checkout("N"))
        Assertions.assertEquals(120, CheckoutSolution.checkout("NNN"))
        Assertions.assertEquals(120, CheckoutSolution.checkout("NNNM"))
        Assertions.assertEquals(110, CheckoutSolution.checkout("NNMM"))

        Assertions.assertEquals(50, CheckoutSolution.checkout("R"))
        Assertions.assertEquals(150, CheckoutSolution.checkout("RRR"))
        Assertions.assertEquals(150, CheckoutSolution.checkout("RRRQ"))
        Assertions.assertEquals(300, CheckoutSolution.checkout("RRRRRRQ"))
        Assertions.assertEquals(330, CheckoutSolution.checkout("RRRRRRQQQ"))
    }

    @Test
    fun offerGetSameOneFree() {
        Assertions.assertEquals(10, CheckoutSolution.checkout("F"))
        Assertions.assertEquals(20, CheckoutSolution.checkout("FF"))
        Assertions.assertEquals(20, CheckoutSolution.checkout("FFF"))
        Assertions.assertEquals(30, CheckoutSolution.checkout("FFFF"))
        Assertions.assertEquals(40, CheckoutSolution.checkout("FFFFF"))
        Assertions.assertEquals(40, CheckoutSolution.checkout("FFFFFF"))

        Assertions.assertEquals(40, CheckoutSolution.checkout("U"))
        Assertions.assertEquals(120, CheckoutSolution.checkout("UUU"))
        Assertions.assertEquals(120, CheckoutSolution.checkout("UUUU"))
        Assertions.assertEquals(160, CheckoutSolution.checkout("UUUUU"))
        Assertions.assertEquals(240, CheckoutSolution.checkout("UUUUUUUU"))
    }
}
