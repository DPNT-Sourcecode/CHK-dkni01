package solutions.SUM

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import solutions.HLO.HelloSolution

class HelloSolutionTest {

    @Test
    fun hello() {
        Assertions.assertEquals("Hello World!", HelloSolution.hello("Ace"))
        
    }

    
}
