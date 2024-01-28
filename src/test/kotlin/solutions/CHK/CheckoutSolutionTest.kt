package solutions.CHK

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CheckoutSolutionTest {

    @Test
    fun checkout() {
//        Assertions.assertEquals(50, CheckoutSolution.checkout("A"))
//        Assertions.assertEquals(30, CheckoutSolution.checkout("B"))
//        Assertions.assertEquals(20, CheckoutSolution.checkout("C"))
//        Assertions.assertEquals(15, CheckoutSolution.checkout("D"))
//        Assertions.assertEquals(40, CheckoutSolution.checkout("E"))
//        Assertions.assertEquals(145, CheckoutSolution.checkout("ABCDDD"))
//
//        Assertions.assertEquals(180, CheckoutSolution.checkout("AAAA"))
//        Assertions.assertEquals(250, CheckoutSolution.checkout("AAAAAA"))
//        Assertions.assertEquals(330, CheckoutSolution.checkout("AAAAAAAA"))
//        
//        Assertions.assertEquals(45, CheckoutSolution.checkout("BB"))
//        Assertions.assertEquals(220, CheckoutSolution.checkout("BBBBAAA"))
        
        Assertions.assertEquals(80, CheckoutSolution.checkout("EEB"))
        Assertions.assertEquals(110, CheckoutSolution.checkout("EEBB"))
        Assertions.assertEquals(160, CheckoutSolution.checkout("EEEEBB"))
//        
        Assertions.assertEquals(-1, CheckoutSolution.checkout("X"))
        Assertions.assertEquals(-1, CheckoutSolution.checkout("A9"))
    }

    
}


