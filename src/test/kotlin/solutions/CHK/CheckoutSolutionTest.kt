package solutions.SUM

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import solutions.CHK.CheckoutSolution
import solutions.HLO.HelloSolution

class CheckoutSolutionTest {

    @Test
    fun checkout() {
        Assertions.assertEquals(50, CheckoutSolution.checkout("A"))
        Assertions.assertEquals(30, CheckoutSolution.checkout("B"))
        Assertions.assertEquals(20, CheckoutSolution.checkout("C"))
        Assertions.assertEquals(15, CheckoutSolution.checkout("D"))

        Assertions.assertEquals(130, CheckoutSolution.checkout("AAA"))
        Assertions.assertEquals(45, CheckoutSolution.checkout("BB"))
        
        Assertions.assertEquals(-1, CheckoutSolution.checkout("X"))
        Assertions.assertEquals(-1, CheckoutSolution.checkout("A9"))
    }

    
}

