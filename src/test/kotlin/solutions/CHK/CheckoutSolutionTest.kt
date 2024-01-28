package solutions.CHK

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CheckoutSolutionTest {

//    @Test
//    fun combined() {
//        Assertions.assertEquals(145, CheckoutSolution.checkout("ABCDDD"))
//        Assertions.assertEquals(220, CheckoutSolution.checkout("BBBBAAA"))
//        Assertions.assertEquals(170, CheckoutSolution.checkout("FFFAAAC"))
//    }

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
        Assertions.assertEquals(-1, CheckoutSolution.checkout("X"))
        Assertions.assertEquals(-1, CheckoutSolution.checkout("A9"))
    }

    // multiple same items tests
    @Test
    fun offerA() {
        Assertions.assertEquals(50, CheckoutSolution.checkout("A"))
        Assertions.assertEquals(180, CheckoutSolution.checkout("AAAA"))
        Assertions.assertEquals(250, CheckoutSolution.checkout("AAAAAA"))
        Assertions.assertEquals(330, CheckoutSolution.checkout("AAAAAAAA"))
    }

    @Test
    fun offerH() {
        Assertions.assertEquals(10, CheckoutSolution.checkout("H"))
        Assertions.assertEquals(40, CheckoutSolution.checkout("HHHH"))
        Assertions.assertEquals(45, CheckoutSolution.checkout("HHHHH"))
        Assertions.assertEquals(65, CheckoutSolution.checkout("HHHHHHH"))
        Assertions.assertEquals(80, CheckoutSolution.checkout("HHHHHHHHHH"))
    }

    @Test
    fun offerB() {
        Assertions.assertEquals(30, CheckoutSolution.checkout("B"))
        Assertions.assertEquals(45, CheckoutSolution.checkout("BB"))
        Assertions.assertEquals(90, CheckoutSolution.checkout("BBBB"))
    }

    @Test
    fun offerBAndE() {
        Assertions.assertEquals(40, CheckoutSolution.checkout("E"))
        Assertions.assertEquals(80, CheckoutSolution.checkout("EE"))
        Assertions.assertEquals(80, CheckoutSolution.checkout("EEB"))
        Assertions.assertEquals(110, CheckoutSolution.checkout("EEBB"))
        Assertions.assertEquals(160, CheckoutSolution.checkout("EEEEBB"))
        Assertions.assertEquals(190, CheckoutSolution.checkout("EEEEBBB"))
    }

    @Test
    fun offerF() {
        Assertions.assertEquals(10, CheckoutSolution.checkout("F"))
        Assertions.assertEquals(20, CheckoutSolution.checkout("FF"))
        Assertions.assertEquals(20, CheckoutSolution.checkout("FFF"))
        Assertions.assertEquals(30, CheckoutSolution.checkout("FFFF"))
        Assertions.assertEquals(40, CheckoutSolution.checkout("FFFFF"))
        Assertions.assertEquals(40, CheckoutSolution.checkout("FFFFFF"))
    }

    @Test
    fun offerU() {
        Assertions.assertEquals(40, CheckoutSolution.checkout("U"))
        Assertions.assertEquals(120, CheckoutSolution.checkout("UUU"))
        Assertions.assertEquals(120, CheckoutSolution.checkout("UUUU"))
        Assertions.assertEquals(160, CheckoutSolution.checkout("UUUUU"))
        Assertions.assertEquals(240, CheckoutSolution.checkout("UUUUUUUU"))
    }
}


